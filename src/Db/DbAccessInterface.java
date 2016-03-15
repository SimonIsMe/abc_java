package Db;

import Query.Query.Queries.CreateQuery;
import Query.Query.Queries.DeleteQuery;
import Query.Query.Queries.ReadQuery;
import Query.Query.Queries.UpdateQuery;

public interface DbAccessInterface
{
    public void read(ReadQuery readQuery);
    public void create(CreateQuery readQuery);
    public void update(UpdateQuery readQuery);
    public void delete(DeleteQuery readQuery);
}
