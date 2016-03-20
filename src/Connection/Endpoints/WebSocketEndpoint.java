package Connection.Endpoints;

import Connection.Client.WebSocketClient;
import Connection.Connection;
import Connection.ConnectionsManager;
import Connection.Message.Exceptions.ParseRequestMessageException;
import Connection.Message.RequestMessage;
import Connection.Message.ResponseExceptionInterface;

import Connection.Message.ResponseMessage;
import Project.Exceptions.ProjectConnectedClientsOverflowException;
import Project.Exceptions.ProjectNotFoundException;
import Project.Project;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/server")
public class WebSocketEndpoint implements EndpointInterface
{
    public void start(int port)
    {
    }

    public void stop()
    {
    }

    @OnOpen
    public void onOpen (Session session)
    {
        Project project = null;
        try {
            project = Project.findProject("identyfikator_projektu");
        } catch (ProjectConnectedClientsOverflowException | ProjectNotFoundException ex) {
            ResponseExceptionInterface exception = (ResponseExceptionInterface) ex;
            this._sendResponse(session, exception.getResponseMessage());
        }

        WebSocketClient client = new WebSocketClient(session, project);
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
            this._sendText(session, EndpointInterface.PONG_MESSAGE);
        }

        Connection connection = ConnectionsManager.getInstance().findConnection(session.getId());
        RequestMessage requestMessage = null;
        try {
            requestMessage = RequestMessage.parse(message, connection);
        } catch (ParseRequestMessageException exception) {
            this._sendResponse(session, exception.getResponseMessage());
        }
        connection.onMessage(requestMessage);
    }

    private void _sendResponse(Session session, ResponseMessage responseMessage)
    {
        this._sendText(session, responseMessage.toString());
    }

    private void _sendText(Session session, String text)
    {
        session.getAsyncRemote().sendText(text);
    }

}
