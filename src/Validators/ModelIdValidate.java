package Validators;

public class ModelIdValidate implements ValidateInterface
{
    private final String _modelName;
    private final String _modelId;

    public ModelIdValidate(String modelName, String modelId)
    {
        this._modelName = modelName;
        this._modelId = modelId;
    }

    public boolean validate()
    {
        return true;
    }
}
