package Connection;

import Connection.Client.ClientInterface;
import Connection.Message.ResponseMessage;

public class Connection
{
    private final String _id;
    private final ClientInterface _client;

    public Connection(String connectionId, ClientInterface client)
    {
        this._id = connectionId;
        this._client = client;
    }

    public Connection(ClientInterface client)
    {
        this._id = "aa";
        this._client = client;
    }

    public String getId()
    {
        return this._id;
    }

    public void send(ResponseMessage message)
    {
        this._client.send(message.toString());
    }

    public void close()
    {
        //  todo
    }

}
