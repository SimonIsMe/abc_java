package Db;

import Query.Query.Queries.*;
import Connection.Connection;

public interface DbAccessInterface
{
    public void getById(GetByIdQuery getByIdQuery, Connection connection);
    public void read(ReadQuery readQuery, Connection connection);
    public void create(CreateQuery createQuery, Connection connection);
    public void update(UpdateQuery updateQuery, Connection connection);
    public void delete(DeleteQuery deleteQuery, Connection connection);
}
