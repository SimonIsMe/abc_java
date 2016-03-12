package Message;

import Query.Query;

public class Message extends AbstractMessage
{
    public final Query _query;

    public Message(Query query)
    {
        this._query = query;
    }
}
