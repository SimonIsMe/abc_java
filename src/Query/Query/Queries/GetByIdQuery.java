package Query.Query.Queries;

import Query.Query.QueryBuilder.AbstractQueryBuilder;

/*
{
    "type" : "GET_BY_ID",
    "queryId" : "abc123def456",
    "modelName" : "User",
    "modelId" : "123abc"
}
 */

public class GetByIdQuery extends AbstractQuery
{
    private final String _modelId;

    public GetByIdQuery(String modelName, String modelId, String queryId)
    {
        super(AbstractQuery.GET_BY_ID_TYPE, modelName, queryId);
        this._modelId = modelId;
    }

    public GetByIdQuery(String modelName, String modelId)
    {
        super(AbstractQuery.GET_BY_ID_TYPE, modelName);
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
