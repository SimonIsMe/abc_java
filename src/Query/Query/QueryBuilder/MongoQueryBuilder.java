package Query.Query.QueryBuilder;

import Query.Query.Conditions.AbstractCondition;
import Query.Query.Query;

import java.util.LinkedList;

public class MongoQueryBuilder extends AbstractQueryBuilder
{
    public MongoQueryBuilder(Query query)
    {
        super(query);
    }

    public String getString()
    {
        return this._joinLogicOperator("$and", this.getQuery().getMust()) +
            this._joinLogicOperator("$or", this.getQuery().getShould()) +
            this._joinLogicOperator("$nor", this.getQuery().getMustNot());
    }

    private String _joinLogicOperator(String operator, LinkedList<AbstractCondition> conditions)
    {
        if (conditions.isEmpty())
            return "";

        LinkedList<String> toReturn = new LinkedList<>();

        for (AbstractCondition condition : conditions) {
            toReturn.add("{" + condition.toString() + "}");
        }

        return "{" + operator + ": [" + String.join(", ", toReturn) + "]}";
    }
}
