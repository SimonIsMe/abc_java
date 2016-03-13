package Connection.Message;

import Connection.Message.Exceptions.ParseRequestMessageException;

public class RequestMessage
{
    public RequestMessage()
    {

    }

    public static RequestMessage parse(String message) throws ParseRequestMessageException
    {
        return new RequestMessage();
    }
}
