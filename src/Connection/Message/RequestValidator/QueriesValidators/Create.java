package Connection.Message.RequestValidator.QueriesValidators;

import org.json.JSONObject;

public class Create extends AbstractQuery
{
    public static final String TYPE = "CREATE";

    public Create(JSONObject query)
    {
        super(query);
    }

    public boolean validate()
    {
        return  super.validate() &&
                this._validateParameters();
    }
}
