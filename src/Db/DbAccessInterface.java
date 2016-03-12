package Db;

import Query.Query.Query;

interface DbAccessInterface
{
    public void read(Query query);
    public void create(Query query);
    public void update(Query query);
    public void delete(Query query);
}
