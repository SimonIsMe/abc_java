package Connection.Message.RequestValidator;

import Connection.Message.RequestValidator.QueriesValidators.*;
import org.json.JSONObject;

public class QueryValidator
{
    private JSONObject _query;

    public QueryValidator(JSONObject query)
    {
        this._query = query;
    }

    public boolean validate()
    {
        AbstractQuery queryValidator = null;

        switch (_query.getString("type")) {
            case Read.TYPE:
                queryValidator = new Read(this._query);
                break;
            case GetById.TYPE:
                queryValidator = new GetById(this._query);
                break;
            case Create.TYPE:
                queryValidator = new Create(this._query);
                break;
            case Update.TYPE:
                queryValidator = new Update(this._query);
                break;
            case Delete.TYPE:
                queryValidator = new Delete(this._query);
                break;
        }

        return queryValidator.validate();
    }
}
