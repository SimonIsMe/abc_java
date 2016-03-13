package Connection.Client;

import javax.websocket.Session;

public class WebSocketClient implements ClientInterface
{
    private final Session _session;

    public WebSocketClient(Session session)
    {
        this._session = session;
    }

    public void send(String message)
    {
        this._session.getAsyncRemote().sendText(message);
    }

    public void onClose()
    {

    }
}
