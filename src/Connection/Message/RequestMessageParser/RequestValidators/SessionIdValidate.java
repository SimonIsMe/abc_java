package Connection.Message.RequestMessageParser.RequestValidators;

import Connection.Auth.Auth;
import Connection.Auth.Exceptions.SessionIdException;

public class SessionIdValidate implements ValidateInterface
{
    private final String _sessionId;

    public SessionIdValidate(String sessionId)
    {
        this._sessionId = sessionId;
    }

    public boolean validate()
    {
        try {
            return Auth.getInstance().validate(this._sessionId);
        } catch (SessionIdException e) {
            e.printStackTrace();
        }
        return false;
    }
}
