package Validators;

public class ModelNameValidate implements ValidateInterface
{
    private final String _modelName;

    public ModelNameValidate(String modelName)
    {
        this._modelName = modelName;
    }

    public boolean validate()
    {
        return true;
    }
}
