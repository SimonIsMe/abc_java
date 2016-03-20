package Validators;

public class ProjectIdValidator implements ValidateInterface
{
    private final String _projectId;

    public ProjectIdValidator(String projectId)
    {
        this._projectId = projectId;
    }

    public boolean validate()
    {
        return false;
    }
}
