package Project.Exceptions;

import Connection.Message.ResponseExceptionInterface;
import Connection.Message.ResponseMessage;

public class ProjectConnectedClientsOverflowException extends ProjectException implements ResponseExceptionInterface
{
    private final String _projectId;

    public ProjectConnectedClientsOverflowException(String projectId)
    {
        this._projectId = projectId;
    }

    public ResponseMessage getResponseMessage()
    {
        ResponseMessage response = new ResponseMessage();
        response.setStatus(ResponseMessage.OVERFLOW_CONNECTIONS_STATUS);
        response.setMessage("Too many clients are connected.");
        return response;
    }
}
