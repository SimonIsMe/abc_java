package Db;

import Query.Query.Queries.ReadQuery;

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

    @Override
    public void read(ReadQuery readQuery)
    {

    }

    @Override
    public void create(ReadQuery readQuery)
    {

    }

    @Override
    public void update(ReadQuery readQuery)
    {

    }

    @Override
    public void delete(ReadQuery readQuery)
    {

    }
}
