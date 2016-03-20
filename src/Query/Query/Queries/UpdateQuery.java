package Query.Query.Queries;

import Query.Query.QueryBuilder.AbstractQueryBuilder;

public class UpdateQuery extends AbstractQuery
{
    private final String _modelId;

    public UpdateQuery(String modelName, String modelId)
    {
        super(AbstractQuery.READ_TYPE, modelName);
        this._modelId = modelId;
    }

    public String getModelId()
    {
        return this._modelId;
    }

    public String toString(AbstractQueryBuilder queryBuilder)
    {
        return queryBuilder.toString();
    }


}
