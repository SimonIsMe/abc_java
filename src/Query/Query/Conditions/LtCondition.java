package Query.Query.Conditions;

import Query.Query.MongoCondition;
import Query.Query.Value;

public class LtCondition extends AbstractCondition
{
    @Override
    protected String _getMongoDbCondition()
    {
        MongoCondition mongoCondition = new MongoCondition(this);
        return mongoCondition.getConditonString(MongoCondition.LT_OPERATOR);
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

    public LtCondition(String columnName, Value value)
    {
        super(columnName, value);
    }


}
