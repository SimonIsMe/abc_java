package Query.Validate;

import Connection.User;
import Query.Query.Query;

public class RowAccess implements ValidateInterface
{
    public static final int CAN_READ_PRIVILEGE = 0;
    public static final int CAN_CREATE_PRIVILEGE = 1;
    public static final int CAN_UPDATE_PRIVILEGE = 2;
    public static final int CAN_DELETE_PRIVILEGE = 3;

    private static RowAccess _instance;

    private RowAccess()
    {
    }

    public static RowAccess getInstance()
    {
        if (_instance == null) {
            _instance = new RowAccess();
        }

        return _instance;
    }

    public boolean checkAccess(Query query) {
        return false;
    }

    public boolean checkPrivileges(User user, String tableName, String[] ids, int privilege)
    {
        return true;
    }
}
