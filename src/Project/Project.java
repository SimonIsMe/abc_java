package Project;

import Project.Exceptions.ProjectConnectedClientsOverflowException;
import Project.Exceptions.ProjectNotFoundException;
import Validators.ProjectIdValidator;
import Validators.ProjectUsersOverflowValidator;

public class Project
{
    private final String _projectId;

    private Project(String projectId)
    {
        this._projectId = projectId;
    }

    public static Project findProject(String projectId) throws ProjectConnectedClientsOverflowException, ProjectNotFoundException
    {
        ProjectIdValidator projectIdValidator = new ProjectIdValidator(projectId);
        if (!projectIdValidator.validate()) {
            throw new ProjectNotFoundException(projectId);
        }

        ProjectUsersOverflowValidator projectUsersOverflowValidator = new ProjectUsersOverflowValidator(projectId);
        if (!projectUsersOverflowValidator.validate()) {
            throw new ProjectConnectedClientsOverflowException(projectId);
        }

        return new Project(projectId);
    }
}
