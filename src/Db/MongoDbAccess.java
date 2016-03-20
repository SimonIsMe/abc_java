package Db;

import Query.Query.Queries.CreateQuery;
import Query.Query.Queries.DeleteQuery;
import Query.Query.Queries.ReadQuery;
import Query.Query.Queries.UpdateQuery;

public class MongoDbAccess implements DbAccessInterface
{
    private static MongoDbAccess _instance;

    private MongoDbAccess()
    {
    }

    public static MongoDbAccess getInstance()
    {
        if (MongoDbAccess._instance == null)
            MongoDbAccess._instance = new MongoDbAccess();

        return MongoDbAccess._instance;
    }

    public void read(ReadQuery readQuery)
    {

    }

    public void create(CreateQuery createQuery)
    {

    }

    public void update(UpdateQuery updateQuery)
    {

    }

    public void delete(DeleteQuery deleteQuery)
    {

    }
}
