package Query.Query.Queries;

import Query.Query.QueryBuilder.AbstractQueryBuilder;

/*
 {
    "type" : "DELETE",
    "queryId" : "abc123def456",
    "modelName" : "User",
    "modelId" : "123abc"
}
 */

public class DeleteQuery extends AbstractQuery
{
    private final String _modelId;

    public DeleteQuery(String modelName, String modelId, String queryId)
    {
        super(AbstractQuery.READ_TYPE, modelName, queryId);
        this._modelId = modelId;
    }

    public DeleteQuery(String modelName, String modelId)
    {
        super(AbstractQuery.READ_TYPE, modelName);
        this._modelId = modelId;
    }

    public String toString(AbstractQueryBuilder queryBuilder)
    {
        return queryBuilder.toString();
    }

    public String getModelId()
    {
        return this._modelId;
    }

}
