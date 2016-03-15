package Query.Query.Queries;

public abstract class AbstractQuery
{
    public static final int READ_TYPE = 0;
    public static final int DELETE_TYPE = 1;
    public static final int UPDATE_TYPE = 2;
    public static final int CREATE_TYPE = 3;

    private final int _type;
    private final String _modelName;

    public AbstractQuery(int type, String modelName)
    {
        this._type = type;
        this._modelName = modelName;
    }

    public int getType()
    {
        return this._type;
    }

    public String getModelName()
    {
        return this._modelName;
    }

}
