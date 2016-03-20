package Query.Query.Queries;

import Connection.Connection;

public abstract class AbstractQuery
{
    public static final int READ_TYPE = 0;
    public static final int DELETE_TYPE = 1;
    public static final int UPDATE_TYPE = 2;
    public static final int CREATE_TYPE = 3;
    public static final int GET_BY_ID_TYPE = 4;

    private final int _type;
    private final String _modelName;
    private final String _queryId;

    public AbstractQuery(int type, String modelName, String queryId)
    {
        this._type = type;
        this._modelName = modelName;
        this._queryId = queryId;
    }

    public AbstractQuery(int type, String modelName)
    {
        this._type = type;
        this._modelName = modelName;
        this._queryId = null;
    }

    public int getType()
    {
        return this._type;
    }

    public String getModelName()
    {
        return this._modelName;
    }

    public String getQueryId()
    {
        return this._queryId;
    }

}
