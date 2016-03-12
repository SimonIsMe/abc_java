package Query.Query;

import Query.Query.Conditions.AbstractCondition;
import Query.Query.QueryBuilder.AbstractQueryBuilder;

import java.util.LinkedList;

public class Query
{
    public static final int READ_TYPE = 0;
    public static final int DELETE_TYPE = 1;
    public static final int UPDATE_TYPE = 2;
    public static final int CREATE_TYPE = 3;

    private final int _type;

    private final String _tableName;

    private final LinkedList<AbstractCondition> _must = new LinkedList<>();
    private final LinkedList<AbstractCondition> _should = new LinkedList<>();
    private final LinkedList<AbstractCondition> _mustNot = new LinkedList<>();

    public Query(int type, String tableName)
    {
        this._type = type;
        this._tableName = tableName;
    }

    public void addMust(AbstractCondition condition)
    {
        this._must.add(condition);
    }

    public void should(AbstractCondition condition)
    {
        this._should.add(condition);
    }

    public void addMustNot(AbstractCondition condition)
    {
        this._mustNot.add(condition);
    }

    public LinkedList<AbstractCondition> getMust()
    {
        return this._must;
    }

    public LinkedList<AbstractCondition> getShould()
    {
        return this._should;
    }

    public LinkedList<AbstractCondition> getMustNot()
    {
        return this._mustNot;
    }

    public String toString(AbstractQueryBuilder queryBuilder)
    {
        return queryBuilder.toString();
    }

    public int getType()
    {
        return this._type;
    }
}
