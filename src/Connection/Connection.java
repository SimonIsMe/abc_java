package Connection;

import Connection.Auth.Exceptions.SessionIdException;
import Connection.Client.ClientInterface;
import Connection.Message.RequestMessage;
import Connection.Message.ResponseMessage;
import Connection.Auth.Auth;

public class Connection
{
    private final String _id;
    private final ClientInterface _client;
    private boolean _isAuth = false;
    private String _userId;

    public Connection(String connectionId, ClientInterface client)
    {
        this._id = connectionId;
        this._client = client;
    }

    public Connection(ClientInterface client)
    {
        this._id = ConnectionIdGenerator.getInstance().getNext();
        this._client = client;
    }

    public String getId()
    {
        return this._id;
    }

    public String getUserId()
    {
        return this._userId;
    }

    public void send(ResponseMessage message)
    {
        this._client.send(message.toString());
    }

    public boolean auth(String sessionId) throws SessionIdException
    {
        this._isAuth = Auth.getInstance().validate(sessionId);
        if (this._isAuth)
            this._userId = Auth.getInstance().getUserId(sessionId);

        return this._isAuth;
    }

    public void onMessage(RequestMessage message)
    {

    }

    public void close()
    {
        //  todo
    }

}
