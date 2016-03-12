package Query.Query.Conditions;

import Query.Query.Value;

abstract public class AbstractCondition
{
    private final String _columnName;
    private final Value _value;

    protected abstract String _getMongoDbCondition();
    protected abstract String _getPostgreSqlCondition();
    protected abstract String _getMySqlCondition();

    public AbstractCondition(String columnName, Value value)
    {
        this._columnName = columnName;
        this._value = value;
    }

    public String toString(int dbType)
    {
        switch (dbType) {
            case 1:
                return this._getMySqlCondition();
            case 2:
                return this._getPostgreSqlCondition();
            case 3:
                return this._getMongoDbCondition();
        }

        return "";
    }

    public String getColumnName()
    {
        return this._columnName;
    }

    public Value getValue()
    {
        return this._value;
    }
}
