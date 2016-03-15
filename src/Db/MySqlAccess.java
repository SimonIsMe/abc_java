package Db;

import Query.Query.Queries.ReadQuery;

public class MySqlAccess implements DbAccessInterface
{
    private static MySqlAccess _instance;

    private MySqlAccess()
    {
    }

    public static MySqlAccess getInstance()
    {
        if (MySqlAccess._instance == null)
            MySqlAccess._instance = new MySqlAccess();

        return MySqlAccess._instance;
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
