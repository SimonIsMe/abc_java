package Query.Query.Queries;

import Query.Query.QueryBuilder.AbstractQueryBuilder;

import java.util.HashMap;

/*

{
    "type" : "CREATE",
    "queryId" : "abc123def456",
    "modelName" : "User",
    "parameters": { ... }
}

*/

public class CreateQuery extends AbstractQuery
{
    private final HashMap<String, String> _parameters;

    public CreateQuery(String modelName, HashMap<String, String> parmeters, String queryId)
    {
        super(AbstractQuery.CREATE_TYPE, modelName, queryId);
        this._parameters = parmeters;
    }

    public CreateQuery(String modelName, HashMap<String, String> parmeters)
    {
        super(AbstractQuery.CREATE_TYPE, modelName);
        this._parameters = parmeters;
    }

    public HashMap<String, String> getParameters()
    {
        return this._parameters;
    }

    public String toString(AbstractQueryBuilder queryBuilder)
    {
        return queryBuilder.toString();
    }


}
