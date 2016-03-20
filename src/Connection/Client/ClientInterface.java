package Connection.Client;

import Project.Project;

public interface ClientInterface
{
    public void send(String message);

    public Project getProject();

    public void onClose();
}
