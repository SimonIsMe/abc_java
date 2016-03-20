package Connection.Client;

import javax.websocket.Session;
import Project.Project;

public class WebSocketClient implements ClientInterface
{
    private final Session _session;
    private final Project _project;

    public WebSocketClient(Session session, Project project)
    {
        this._session = session;
        this._project = project;
    }

    public Project getProject()
    {
        return this._project;
    }

    public void send(String message)
    {
        this._session.getAsyncRemote().sendText(message);
    }

    public void onClose()
    {

    }
}
