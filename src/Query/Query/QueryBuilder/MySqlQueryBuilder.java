package Query.Query.QueryBuilder;

import Query.Query.Conditions.AbstractCondition;
import Query.Query.Query;

import java.util.LinkedList;

public class MySqlQueryBuilder extends AbstractQueryBuilder
{
    public MySqlQueryBuilder(Query query)
    {
        super(query);
    }

    public String getString()
    {
        LinkedList<String> toReturn = new LinkedList<>();

        if (this.getQuery().getMust().isEmpty()) {
            toReturn.add("(" + this._joinLogicOperator("AND", this.getQuery().getMust()) + ")");
        }

        if (this.getQuery().getShould().isEmpty()) {
            toReturn.add("(" + this._joinLogicOperator("OR", this.getQuery().getShould()) + ")");
        }

        String toReturnString = String.join(" AND ", toReturn);

        if (this.getQuery().getShould().isEmpty()) {

            if (!toReturnString.isEmpty())
                toReturnString += " AND ";

            toReturnString += " NOT(" + this._joinLogicOperator("OR", this.getQuery().getMustNot()) + ")";
        }

        return toReturnString;
    }

    private String _joinLogicOperator(String operator, LinkedList<AbstractCondition> conditions)
    {
        if (conditions.isEmpty())
            return "";

        LinkedList<String> toReturn = new LinkedList<>();

        for (AbstractCondition condition : conditions) {
            toReturn.add("(" + condition.toString() + ")");
        }

        return "(" + String.join(" " + operator + " ", toReturn) + ")";
    }
}
