package Validators;

public class QueryIdValidate implements ValidateInterface
{
    private final String _queryId;

    public QueryIdValidate(String queryId)
    {
        this._queryId = queryId;
    }

    public boolean validate()
    {
        return !this._queryId.isEmpty();
    }
}
