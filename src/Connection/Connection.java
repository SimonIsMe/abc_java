package Connection;

import Connection.Client.ClientInterface;
import Connection.Message.RequestMessage;
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
        this._id = ConnectionIdGenerator.getInstance().getNext();
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

    public void onMessage(RequestMessage message)
    {

    }

    public void close()
    {
        //  todo
    }

}
