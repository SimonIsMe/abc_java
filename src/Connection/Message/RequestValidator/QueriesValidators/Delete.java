package Connection.Message.RequestValidator.QueriesValidators;

import org.json.JSONObject;

public class Delete extends AbstractQuery
{
    public static final String TYPE = "DELETE";

    public Delete(JSONObject query)
    {
        super(query);
    }

    public boolean validate()
    {
        return  super.validate() &&
                this._validateModelId();
    }
}
