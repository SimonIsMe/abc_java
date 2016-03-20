package Query.Validate;

import Query.Query.Queries.AbstractQuery;
import Project.Project;

interface ValidateInterface
{
    public boolean checkAccess(AbstractQuery readQuery, Project project);
}
