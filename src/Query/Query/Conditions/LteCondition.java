package Query.Query.Conditions;

import Query.Query.MongoCondition;
import Query.Query.Value;

public class LteCondition extends AbstractCondition
{
    @Override
    protected String _getMongoDbCondition()
    {
        MongoCondition mongoCondition = new MongoCondition(this);
        return mongoCondition.getConditonString(MongoCondition.LTE_OPERATOR);
    }

    @Override
    protected String _getPostgreSqlCondition()
    {
        return "";
    }

    @Override
    protected String _getMySqlCondition()
    {
        return "";
    }

    public LteCondition(String columnName, Value value)
    {
        super(columnName, value);
    }


}
