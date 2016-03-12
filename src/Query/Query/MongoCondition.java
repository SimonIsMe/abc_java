package Query.Query;

import Query.Query.Conditions.AbstractCondition;

public class MongoCondition
{
    public static final String EQ_OPERATOR = "$eq";
    public static final String GT_OPERATOR = "$gt";
    public static final String GTE_OPERATOR = "$gte";
    public static final String LT_OPERATOR = "$lt";
    public static final String LTE_OPERATOR = "$lte";
    public static final String NE_OPERATOR = "$ne";
    public static final String IN_OPERATOR = "$in";
    public static final String NIN_OPERATOR = "$nin";

    private final AbstractCondition _condition;

    public MongoCondition(AbstractCondition condition)
    {
        this._condition = condition;
    }

    public String getConditonString(String operator)
    {
        if (operator.equals(EQ_OPERATOR) ||
            operator.equals(GT_OPERATOR) ||
            operator.equals(GTE_OPERATOR) ||
            operator.equals(LT_OPERATOR) ||
            operator.equals(LTE_OPERATOR) ||
            operator.equals(NE_OPERATOR)
        ) {
            switch (this._condition.getValue().getType()) {
                case Value.STRING_TYPE:
                    return "{" + this._condition.getColumnName() + ": {" + operator + ": \"" + this._condition.getValue().getString() + "\"}}";
                case Value.INT_TYPE:
                    return "{" + this._condition.getColumnName() + ": {" + operator + ": " + this._condition.getValue().getInt() + "}}";
                case Value.LONG_TYPE:
                    return "{" + this._condition.getColumnName() + ": {" + operator + ": " + this._condition.getValue().getLong() + "}}";
            }
        }

        if (operator.equals(IN_OPERATOR) ||
            operator.equals(NIN_OPERATOR)) {
            //  todo
        }

        return "";
    }
}
