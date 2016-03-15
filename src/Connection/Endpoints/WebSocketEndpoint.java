package Connection.Endpoints;

import Connection.Client.WebSocketClient;
import Connection.Connection;
import Connection.ConnectionsManager;
import Connection.Message.Exceptions.ParseRequestMessageException;
import Connection.Message.RequestMessage;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/server")
public class WebSocketEndpoint implements EndpointInterface
{
    @OnOpen
    public void onOpen (Session session)
    {
        WebSocketClient client = new WebSocketClient(session);
        Connection connection = new Connection(session.getId(), client);
        ConnectionsManager.getInstance().registerConnection(connection);
    }

    @OnClose
    public void onClose (Session session)
    {
        ConnectionsManager.getInstance().unregisterConnection(session.getId());
    }

    @OnMessage
    public void onMessage(String message, Session session)
    {
        if (message.equals(EndpointInterface.PING_MESSAGE)) {
            session.getAsyncRemote().sendText(EndpointInterface.PONG_MESSAGE);
        }

        Connection connection = ConnectionsManager.getInstance().findConnection(session.getId());
        RequestMessage requestMessage = null;
        try {
            requestMessage = RequestMessage.parse(message, connection);
        } catch (ParseRequestMessageException exception) {
            session.getAsyncRemote().sendText(exception.toString());
        }
        connection.onMessage(requestMessage);
    }
}
