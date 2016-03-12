package Query;

import Db.DbAccessInterface;
import Db.MySqlAccess;
import Query.Query.Query;
import Query.Validate.RowAccess;
import Query.Validate.TableAccess;

class ExecuteQuery
{
    public void execute(Query query)
    {
        switch (query.getType()) {
            case Query.READ_TYPE:
            case Query.UPDATE_TYPE:
            case Query.DELETE_TYPE:
                if (TableAccess.getInstance().checkAccess(query) &&
                    RowAccess.getInstance().checkAccess(query)) {
                    this._runQueryInDatabase(query);
                }
                break;
            case Query.CREATE_TYPE:
                if (TableAccess.getInstance().checkAccess(query)) {
                    this._runQueryInDatabase(query);
                }
                break;
        }
    }

    private void _runQueryInDatabase(Query query)
    {
        DbAccessInterface dbAccess = MySqlAccess.getInstance();

        switch (query.getType()) {
            case Query.READ_TYPE:
                dbAccess.read(query);
                break;
            case Query.DELETE_TYPE:
                dbAccess.delete(query);
                break;
            case Query.CREATE_TYPE:
                dbAccess.create(query);
                break;
            case Query.UPDATE_TYPE:
                dbAccess.update(query);
                break;
        }
    }

}
