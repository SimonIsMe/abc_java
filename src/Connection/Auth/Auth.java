package Connection.Auth;

import Connection.Auth.Exceptions.SessionIdException;

public class Auth
{
    private static Auth _instance;

    private Auth()
    {}

    public static Auth getInstance()
    {
        if (Auth._instance == null)
            Auth._instance = new Auth();

        return Auth._instance;
    }

    public boolean validate(String sessionId) throws SessionIdException
    {
        return true;
    }
}
