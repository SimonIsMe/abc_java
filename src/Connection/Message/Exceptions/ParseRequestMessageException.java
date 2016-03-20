package Connection.Message.Exceptions;

import Connection.Message.ResponseExceptionInterface;
import Connection.Message.ResponseMessage;

public class ParseRequestMessageException extends MessageException implements ResponseExceptionInterface
{

    public ResponseMessage getResponseMessage()
    {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage("Can not parse the request message.");
        responseMessage.setStatus(ResponseMessage.ERROR_STATUS);
        return responseMessage;
    }
}
