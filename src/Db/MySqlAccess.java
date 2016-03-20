package Db;

import Query.Query.Queries.CreateQuery;
import Query.Query.Queries.DeleteQuery;
import Query.Query.Queries.ReadQuery;
import Query.Query.Queries.UpdateQuery;

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
