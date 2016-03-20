package Project.Exceptions;

import Connection.Message.ResponseExceptionInterface;
import Connection.Message.ResponseMessage;

public class ProjectNotFoundException extends ProjectException implements ResponseExceptionInterface
{
    private final String _projectId;

    public ProjectNotFoundException(String projectId)
    {
        this._projectId = projectId;
    }

    public ResponseMessage getResponseMessage()
    {
        ResponseMessage response = new ResponseMessage();
        response.setStatus(ResponseMessage.PROJECT_NOT_FOUND_STATUS);
        response.setMessage("Project with ID = '" + this._projectId + "' is not found.");
        return response;
    }
}
