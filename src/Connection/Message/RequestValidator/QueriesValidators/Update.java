package Connection.Message.RequestValidator.QueriesValidators;

import org.json.JSONObject;

public class Update extends AbstractQuery
{
    public static final String TYPE = "UPDATE";

    public Update(JSONObject query)
    {
        super(query);
    }

    public boolean validate()
    {
        return  super.validate() &&
                this._validateModelId() &&
                this._validateParameters();
    }
}
