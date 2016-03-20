package Validators;

public class ProjectUsersOverflowValidator implements ValidateInterface
{
    private final String _projectId;

    public ProjectUsersOverflowValidator(String projectId)
    {
        this._projectId = projectId;
    }

    public boolean validate()
    {
        return true;
    }
}
