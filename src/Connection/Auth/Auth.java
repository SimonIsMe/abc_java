package Connection.Auth;

import Connection.Auth.Exceptions.SessionIdException;
import Connection.Auth.Sources.RedisSource;
import Connection.Auth.Sources.SourceInterface;

public class Auth
{
    private static Auth _instance;

    private SourceInterface _source;

    private Auth()
    {
        this._source = RedisSource.getInstance();
    }

    public static Auth getInstance()
    {
        if (Auth._instance == null)
            Auth._instance = new Auth();

        return Auth._instance;
    }

    public boolean validate(String sessionId) throws SessionIdException
    {
        return this._source.isKey(sessionId);
    }

    public String getUserId(String sessionId) throws SessionIdException
    {
        return this._source.get(sessionId);
    }

    public boolean closeSession(String sessionId)
    {
        return this._source.delete(sessionId);
    }
}
