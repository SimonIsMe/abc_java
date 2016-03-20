package Notification.Repositories;

import Connection.Connection;
import Notification.NotifyResponseMessage;
import Notification.Repositories.HashMapRepositoryClasses.Observers;
import Notification.Settings;

public class HashMapRepository implements NotificationInterface
{
    private Observers _collectionsObservers = new Observers();
    private Observers _modelsObservers = new Observers();

    @Override
    public boolean addObserver(Connection connection, String modelName, String[] modelsIds, Settings settings)
    {
        for (String modelId : modelsIds) {
            this._modelsObservers.addObserver(connection, this._getModelNameId(modelName, modelId), settings);
        }

        return true;
    }

    @Override
    public boolean removeObserver(Connection connection, String modelName, String[] modelsIds)
    {
        for (String modelId : modelsIds) {
            this._modelsObservers.removeObserver(connection, this._getModelNameId(modelName, modelId));
        }
        return false;
    }

    @Override
    public void notifyAll(String modelName, String[] modelsIds, int changeType)
    {
        for (String modelId : modelsIds) {
            NotifyResponseMessage notifyMessage = new NotifyResponseMessage();
            this._modelsObservers.notifyAll(this._getModelNameId(modelName, modelId), changeType, notifyMessage);
        }
    }

    private String _getModelNameId(String modelName, String modelId)
    {
        return modelName + "|" + modelId;
    }


    @Override
    public boolean addObserver(Connection connection, String modelName, Settings settings)
    {
        return this._collectionsObservers.addObserver(connection, modelName, settings);
    }


    @Override
    public boolean removeObserver(Connection connection, String modelName)
    {
        return this._collectionsObservers.removeObserver(connection, modelName);
    }

    @Override
    public void notifyAll(String modelName, int changeType)
    {
        NotifyResponseMessage notifyMessage = new NotifyResponseMessage();
        this._collectionsObservers.notifyAll(modelName, changeType, notifyMessage);
    }

}
