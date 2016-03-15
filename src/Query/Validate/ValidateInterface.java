package Query.Validate;

import Query.Query.Queries.AbstractQuery;

interface ValidateInterface
{
    public boolean checkAccess(AbstractQuery readQuery);
}
