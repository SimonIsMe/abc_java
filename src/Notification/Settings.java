package Notification;

public class Settings
{
    private final boolean _create;
    private final boolean _update;
    private final boolean _delete;

    public Settings(boolean create, boolean update, boolean delete)
    {
        this._create = create;
        this._update = update;
        this._delete = delete;
    }

    public boolean isCreate()
    {
        return _create;
    }

    public boolean isUpdate()
    {
        return _update;
    }

    public boolean isDelete()
    {
        return _delete;
    }
}
