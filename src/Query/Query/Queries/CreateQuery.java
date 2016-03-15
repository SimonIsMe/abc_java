package Query.Query.Queries;

import Query.Query.QueryBuilder.AbstractQueryBuilder;

public class CreateQuery extends AbstractQuery
{
    public CreateQuery(String modelName)
    {
        super(AbstractQuery.READ_TYPE, modelName);
    }

    public String toString(AbstractQueryBuilder queryBuilder)
    {
        return queryBuilder.toString();
    }


}
