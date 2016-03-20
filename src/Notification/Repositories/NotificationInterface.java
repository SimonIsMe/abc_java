package Notification.Repositories;

import Connection.Connection;
import Notification.Settings;

public interface NotificationInterface
{
    /**
     * Dodaje obserwatora do wskazanych modeli
     */
    public boolean addObserver(Connection connection, String modelName, String[] modelsIds, Settings settings);

    /**
     * Dodaje obserwatora do całej kolekcji
     */
    public boolean addObserver(Connection connection, String modelName, Settings settings);

    /**
     * Usuwa obserwatora ze wskazanych modelis
     */
    public boolean removeObserver(Connection connection, String modelName, String[] modelsIds);

    /**
     * Usuwa obserwatora z całej kolekcji
     */
    public boolean removeObserver(Connection connection, String modelName);

    /**
     * Informuje wszystkich słuchaczy, że nastąpiła zmiana w kolekcji
     */
    public void notifyAll(String modelName, int changeType);

    /**
     * Informuje wszystkich słuchaczy, że nastąpiła zmiana we wskazanych modelach
     */
    public void notifyAll(String modelName, String[] modelsIds, int changeType);
}
