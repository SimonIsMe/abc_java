package Notification.Repositories.HashMapRepositoryClasses;

import Connection.Connection;
import Notification.NotifyResponseMessage;
import Notification.Settings;

import java.util.HashMap;
import java.util.LinkedList;

public class Observers
{
    public static final int CREATE_TYPE = 1;
    public static final int UPDATE_TYPE = 2;
    public static final int DELETE_TYPE = 3;

    private HashMap<Integer, HashMap<String, LinkedList<Connection>>> _observers = new HashMap<>();

    public Observers()
    {
        this._observers.put(CREATE_TYPE, new HashMap<>());
        this._observers.put(UPDATE_TYPE, new HashMap<>());
        this._observers.put(DELETE_TYPE, new HashMap<>());
    }

    public boolean addObserver(Connection connection, String observerName, Settings settings)
    {
        if (settings.isCreate())
            this._addObserver(CREATE_TYPE, connection, observerName);

        if (settings.isUpdate())
            this._addObserver(UPDATE_TYPE, connection, observerName);

        if (settings.isDelete())
            this._addObserver(DELETE_TYPE, connection, observerName);

        return true;
    }

    private void _addObserver(int type, Connection connection, String observerName)
    {
        LinkedList<Connection> connections = this._observers.get(type).get(observerName);
        if (connections == null) {
            connections = new LinkedList<>();
            this._observers.get(type).put(observerName, connections);
        }

        connections.add(connection);
    }

    public boolean removeObserver(Connection connection, String observerName)
    {
        boolean isRemoved = this._removeObservers(CREATE_TYPE, connection, observerName);
        isRemoved |= this._removeObservers(UPDATE_TYPE, connection, observerName);
        isRemoved |= this._removeObservers(DELETE_TYPE, connection, observerName);

        return isRemoved;
    }

    private boolean _removeObservers(int type, Connection connection, String observerName)
    {
        LinkedList<Connection> connections = this._observers.get(type).get(observerName);
        if (connections == null || connections.isEmpty())
            return false;

        boolean isRemoved = connections.remove(connection);

        if (connections.isEmpty())
            this._observers.get(type).remove(observerName);

        return isRemoved;
    }

    public void notifyAll(String observerName, int changeType, NotifyResponseMessage notifyMessage)
    {
        for (Connection connection : this._observers.get(changeType).get(observerName)) {
            connection.send(notifyMessage);
        }
    }

    public int countConnections(int changeType, String observerName)
    {
        if (this._observers.get(changeType) == null)
            return 0;

        if (this._observers.get(changeType).get(observerName) == null)
            return 0;

        return this._observers.get(changeType).get(observerName).size();
    }

}
