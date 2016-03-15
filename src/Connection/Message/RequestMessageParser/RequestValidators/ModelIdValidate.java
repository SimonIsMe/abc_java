package Connection.Message.RequestMessageParser.RequestValidators;

public class ModelIdValidate implements ValidateInterface
{
    private final String _modelName;
    private final String _modelId;
    private final String _userId;

    public ModelIdValidate(String modelName, String modelId, String userId)
    {
        this._modelName = modelName;
        this._modelId = modelId;
        this._userId = userId;
    }

    public boolean validate()
    {
        return true;
    }
}
