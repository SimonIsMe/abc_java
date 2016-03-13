package Connection;

import java.util.HashMap;

public class ConnectionsManager
{
    private static ConnectionsManager _connectionsManager;

    private final HashMap<String, Connection> _connections = new HashMap<>();

    private ConnectionsManager()
    {}

    public static ConnectionsManager getInstance()
    {
        if (_connectionsManager == null)
            _connectionsManager = new ConnectionsManager();

        return _connectionsManager;
    }

    public void registerConnection(Connection connection)
    {
        this._connections.put(connection.getId(), connection);
    }

    public boolean unregisterConnection(String connectionId)
    {
        Connection connection = this._connections.remove(connectionId);
        if (connection == null)
            return false;

        connection.close();
        return true;
    }

    public Connection findConnection(String connectionId)
    {
        return this._connections.remove(connectionId);
    }
}
