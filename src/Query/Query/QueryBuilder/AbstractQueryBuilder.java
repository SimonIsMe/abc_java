package Query.Query.QueryBuilder;

import Query.Query.Queries.ReadQuery;;

public abstract class AbstractQueryBuilder
{
    private final ReadQuery _Read_query;

    abstract public String getString();

    public AbstractQueryBuilder(ReadQuery readQuery)
    {
        this._Read_query = readQuery;
    }

    public ReadQuery getQuery()
    {
        return this._Read_query;
    }
}
