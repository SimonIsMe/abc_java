package Project;

public class DbConfig
{
    public static int MYSQL_TYPE = 1;
    public static int POSTGRESQL_TYPE = 2;
    public static int MONGODB_TYPE = 3;

    private final int _type;
    private final String _host;
    private final int _port;
    private final String _database;
    private final String _login;
    private final String _password;

    private DbConfig(int type, String host, int port, String database, String login, String password)
    {
        this._type = type;
        this._host = host;
        this._port = port;
        this._database = database;
        this._login = login;
        this._password = password;
    }

    public static DbConfig load(String projectId)
    {
        return new DbConfig(MYSQL_TYPE, "127.0.0.1", 22, "baza danych", "login", "hasło");
    }

    public int getType()
    {
        return this._type;
    }

    public String getHost()
    {
        return this._host;
    }

    public int getPort()
    {
        return this._port;
    }

    public String getDatabase()
    {
        return this._database;
    }

    public String getLogin()
    {
        return this._login;
    }

    public String getPassword()
    {
        return this._password;
    }
}
