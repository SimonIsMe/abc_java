package Connection.Message.Exceptions;

import Connection.Message.ResponseMessage;

public class ParseRequestMessageException extends MessageException
{
    public String toString()
    {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage("Can not parse the request message.");
        responseMessage.setStatus(ResponseMessage.ERROR_STATUS);
        return responseMessage.toString();
    }
}
