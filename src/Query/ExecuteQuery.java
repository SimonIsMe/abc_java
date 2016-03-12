package Query;

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

                }
                break;
            case Query.CREATE_TYPE:
                if (TableAccess.getInstance().checkAccess(query)) {

                }
                break;
        }
    }

}
