package Query;

import Db.DbAccessInterface;
import Db.MySqlAccess;
import Query.Query.Queries.*;
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
                if (TableAccess.getInstance().checkAccess(query) &&
                    RowAccess.getInstance().checkAccess(query)) {
                    this._runQueryInDatabase(query);
                }
                break;
            case ReadQuery.CREATE_TYPE:
                if (TableAccess.getInstance().checkAccess(query)) {
                    this._runQueryInDatabase(query);
                }
                break;
        }
    }

    private void _runQueryInDatabase(AbstractQuery query)
    {
        DbAccessInterface dbAccess = MySqlAccess.getInstance();

        switch (query.getType()) {
            case ReadQuery.READ_TYPE:
                dbAccess.read((ReadQuery) query);
                break;
            case ReadQuery.DELETE_TYPE:
                dbAccess.delete((DeleteQuery) query);
                break;
            case ReadQuery.CREATE_TYPE:
                dbAccess.create((CreateQuery) query);
                break;
            case ReadQuery.UPDATE_TYPE:
                dbAccess.update((UpdateQuery) query);
                break;
        }
    }

}
