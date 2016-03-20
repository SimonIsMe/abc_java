package Connection.Message.RequestValidator.QueriesValidators;

import Validators.ModelIdValidate;
import Validators.ModelNameValidate;
import Validators.QueryIdValidate;
import org.json.JSONObject;

abstract public class AbstractQuery
{
    public static final String QUERY_ID_LABEL = "queryId";
    public static final String MODEL_ID_LABEL = "modelId";
    public static final String MODEL_NAME_LABEL = "modelName";

    private final JSONObject _query;

    public AbstractQuery(JSONObject query)
    {
        this._query = query;
    }

    public boolean validate()
    {
        return this._validateQueryId() && this._validateModelName();
    }

    private boolean _validateQueryId()
    {
        QueryIdValidate queryIdValidate = new QueryIdValidate(this._query.getString(QUERY_ID_LABEL));
        return queryIdValidate.validate();
    }

    private boolean _validateModelName()
    {
        ModelNameValidate modelNameValidate = new ModelNameValidate(this._query.getString(MODEL_NAME_LABEL));
        return modelNameValidate.validate();
    }

    protected boolean _validateModelId()
    {
        String modelName = this._query.getString(MODEL_NAME_LABEL);
        String modelId = this._query.getString(MODEL_ID_LABEL);

        ModelIdValidate modelIdValidate = new ModelIdValidate(modelName, modelId);
        return modelIdValidate.validate();
    }

    protected boolean _validateParameters()
    {
        //  todo
        return true;
    }

}
