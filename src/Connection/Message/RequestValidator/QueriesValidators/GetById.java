package Connection.Message.RequestValidator.QueriesValidators;

import org.json.JSONObject;

public class GetById extends AbstractQuery
{
    public static final String TYPE = "GET_BY_ID";

    public GetById(JSONObject query)
    {
        super(query);
    }

    public boolean validate()
    {
        return super.validate() && this._validateModelId();
    }
}
