package Query.Query.Queries;

import Query.Query.QueryBuilder.AbstractQueryBuilder;

public class UpdateQuery extends AbstractQuery
{
    public UpdateQuery(String modelName)
    {
        super(AbstractQuery.READ_TYPE, modelName);
    }

    public String toString(AbstractQueryBuilder queryBuilder)
    {
        return queryBuilder.toString();
    }


}
