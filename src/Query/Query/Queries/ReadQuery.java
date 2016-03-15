package Query.Query.Queries;

import Query.Query.Conditions.AbstractCondition;
import Query.Query.Queries.AbstractQuery;
import Query.Query.QueryBuilder.AbstractQueryBuilder;

import java.util.LinkedList;

public class ReadQuery extends AbstractQuery
{
    private final LinkedList<AbstractCondition> _must = new LinkedList<>();
    private final LinkedList<AbstractCondition> _should = new LinkedList<>();
    private final LinkedList<AbstractCondition> _mustNot = new LinkedList<>();

    public ReadQuery(String modelName)
    {
        super(AbstractQuery.READ_TYPE, modelName);
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


}
