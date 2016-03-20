package Query;

import Db.DbAccessInterface;
import Db.MySqlAccess;
import Notification.NotificationManager;
import Query.Query.Queries.*;
import Query.Query.Queries.AbstractQuery;
import Query.Validate.RowAccess;
import Query.Validate.TableAccess;
import Connection.Connection;

public class ExecuteQuery
{
    public void execute(AbstractQuery query, Connection connection)
    {
        switch (query.getType()) {
            case ReadQuery.READ_TYPE:
            case ReadQuery.UPDATE_TYPE:
            case ReadQuery.DELETE_TYPE:
                if (TableAccess.getInstance().checkAccess(query, connection.getClient().getProject()) &&
                    RowAccess.getInstance().checkAccess(query, connection.getClient().getProject())) {
                    this._runQueryInDatabase(query, connection);
                }
                break;
            case ReadQuery.CREATE_TYPE:
                if (TableAccess.getInstance().checkAccess(query, connection.getClient().getProject())) {
                    this._runQueryInDatabase(query, connection);
                }
                break;
        }
    }

    private void _runQueryInDatabase(AbstractQuery query, Connection connection)
    {
        DbAccessInterface dbAccess = MySqlAccess.getInstance();


        switch (query.getType()) {
            case ReadQuery.READ_TYPE:
                dbAccess.read((ReadQuery) query);
                break;
            case ReadQuery.DELETE_TYPE:
                DeleteQuery deleteQuery = (DeleteQuery) query;
                dbAccess.delete(deleteQuery);
                this._notifyAfterDelete(deleteQuery, connection);
                break;
            case ReadQuery.CREATE_TYPE:
                CreateQuery createQuery = (CreateQuery) query;
                dbAccess.create(createQuery);
                this._notifyAfterCreate(createQuery, connection);
                break;
            case ReadQuery.UPDATE_TYPE:
                UpdateQuery updateQuery = (UpdateQuery) query;
                dbAccess.update(updateQuery);
                this._notifyAfterUpdate(updateQuery, connection);
                break;
        }
    }

    private void _notifyAfterDelete(DeleteQuery deleteQuery, Connection connection)
    {
        NotificationManager notification = NotificationManager.getInstance(connection.getClient().getProject().getId());
        notification.notifyAll(deleteQuery.getModelName(), NotificationManager.CHANGE_DELETE);
        notification.notifyAll(deleteQuery.getModelName(), new String[]{deleteQuery.getModelId()}, NotificationManager.CHANGE_DELETE);
    }

    private void _notifyAfterCreate(CreateQuery createQuery, Connection connection)
    {
        NotificationManager notification = NotificationManager.getInstance(connection.getClient().getProject().getId());
        notification.notifyAll(createQuery.getModelName(), NotificationManager.CHANGE_CREATE);
    }

    private void _notifyAfterUpdate(UpdateQuery updateQuery, Connection connection)
    {
        NotificationManager notification = NotificationManager.getInstance(connection.getClient().getProject().getId());
        notification.notifyAll(updateQuery.getModelName(), NotificationManager.CHANGE_UPDATE);
        notification.notifyAll(updateQuery.getModelName(), new String[]{updateQuery.getModelId()}, NotificationManager.CHANGE_DELETE);
    }

}
