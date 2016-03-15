package Connection.Message.RequestMessageParser.QueryDecorators.RequestValidators;

public class ModelNameValidate implements ValidateInterface
{
    private final String _modelName;
    private final String _userId;

    public ModelNameValidate(String modelName, String userId)
    {
        this._modelName = modelName;
        this._userId = userId;
    }

    public boolean validate()
    {
        return true;
    }
}
