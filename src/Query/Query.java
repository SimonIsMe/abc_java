package Query;

public class Query
{
    public static final int READ_TYPE = 0;
    public static final int DELETE_TYPE = 1;
    public static final int UPDATE_TYPE = 2;
    public static final int CREATE_TYPE = 3;

    private final int _type;

    public Query(int type)
    {
        this._type = type;
    }

    public int getType()
    {
        return this._type;
    }
}
