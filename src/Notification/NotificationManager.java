package Notification;

import Connection.Connection;
import Notification.Repositories.HashMapRepository;
import Notification.Repositories.NotificationInterface;

import java.util.HashMap;

public class NotificationManager
{
    public static final int CHANGE_READ = 0;
    public static final int CHANGE_CREATE = 1;
    public static final int CHANGE_UPDATE = 2;
    public static final int CHANGE_DELETE = 3;

    private static HashMap<String, NotificationManager> _instances = new HashMap<>();

    private NotificationInterface _notificationRepo;

    private NotificationManager()
    {
        this._notificationRepo = new HashMapRepository();
    }

    public static NotificationManager getInstance(String projectId)
    {
        if (_instances.get(projectId) == null)
            _instances.put(projectId, new NotificationManager());

        return _instances.get(projectId);
    }

    /**
     * Dodaje obserwatora do wskazanych modeli
     */
    public boolean addObserver(Connection connection, String modelName, String[] modelsIds, Settings settings)
    {
        return this._notificationRepo.addObserver(connection, modelName, modelsIds, settings);
    }

    /**
     * Dodaje obserwatora do całej kolekcji
     */
    public boolean addObserver(Connection connection, String modelName, Settings settings)
    {
        return this._notificationRepo.addObserver(connection, modelName, settings);
    }

    /**
     * Usuwa obserwatora ze wskazanych modelis
     */
    public boolean removeObserver(Connection connection, String modelName, String[] modelsIds)
    {
        return this._notificationRepo.removeObserver(connection, modelName, modelsIds);
    }

    /**
     * Usuwa obserwatora z całej kolekcji
     */
    public boolean removeObserver(Connection connection, String modelName)
    {
        return this._notificationRepo.removeObserver(connection, modelName);
    }

    /**
     * Informuje wszystkich słuchaczy, że nastąpiła zmiana w kolekcji
     */
    public void notifyAll(String modelName, int changeType)
    {
        this._notificationRepo.notifyAll(modelName, changeType);
    }

    /**
     * Informuje wszystkich słuchaczy, że nastąpiła zmiana we wskazanych modelach
     */
    public void notifyAll(String modelName, String[] modelsIds, int changeType)
    {
        this._notificationRepo.notifyAll(modelName, modelsIds, changeType);
    }

}
