package Connection.Message.RequestMessageParser.QueryDecorators;

import Connection.Message.RequestMessageParser.RequestValidators.ModelIdValidate;
import Connection.Message.RequestMessageParser.RequestValidators.ModelNameValidate;
import Connection.Message.RequestMessageParser.RequestMessageQueryParser;

public class AbstractCreateUpdateDeleteDecorator extends AbstractDecorator
{
    public static final String MODEL_NAME_LABEL = "modelName";
    public static final String MODEL_ID_LABEL = "modelId";

    public static final int MODEL_NAME_ERROR_CODE = 301;
    public static final int MODEL_ID_ERROR_CODE = 302;

    public AbstractCreateUpdateDeleteDecorator(RequestMessageQueryParser requestMessageParser, String userId)
    {
        super(requestMessageParser, userId);
    }

    public boolean validate()
    {
        return this._validateModelName() && this._validateModelId();
    }

    private boolean _validateModelName()
    {
        String modelName = this.getJsonQuery().getString(MODEL_NAME_LABEL);
        String userId = this.getUserId();

        ModelNameValidate validateModelName = new ModelNameValidate(modelName, userId);

        if (modelName.isEmpty() || !validateModelName.validate())
            this.addErrorCode(MODEL_NAME_ERROR_CODE);

        return true;
    }

    private boolean _validateModelId()
    {
        String modelName = this.getJsonQuery().getString(MODEL_NAME_LABEL);
        String modelId = this.getJsonQuery().getString(MODEL_ID_LABEL);
        String userId = this.getUserId();

        ModelIdValidate validateModelId = new ModelIdValidate(modelName, modelId, userId);

        if (modelName.isEmpty() || modelId.isEmpty() || !validateModelId.validate())
            this.addErrorCode(MODEL_ID_ERROR_CODE);

        return true;
    }

}
