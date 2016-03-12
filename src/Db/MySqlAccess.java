package Db;

import Query.Query.Query;

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
    public void read(Query query)
    {

    }

    @Override
    public void create(Query query)
    {

    }

    @Override
    public void update(Query query)
    {

    }

    @Override
    public void delete(Query query)
    {

    }
}
