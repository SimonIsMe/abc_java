package Query.Query.QueryBuilder;

import Query.Query.Query;;

public abstract class AbstractQueryBuilder
{
    private final Query _query;

    abstract public String getString();

    public AbstractQueryBuilder(Query query)
    {
        this._query = query;
    }

    public Query getQuery()
    {
        return this._query;
    }
}
