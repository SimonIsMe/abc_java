package Connection.Message.RequestValidator.QueriesValidators;

import org.json.JSONObject;

public class Read extends AbstractQuery
{
    public static final String TYPE = "READ";

    public Read(JSONObject query)
    {
        super(query);
    }

    public boolean validate()
    {
        //  todo
        return super.validate();
    }
}
