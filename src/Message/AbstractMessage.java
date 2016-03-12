package Message;

import Client.AbstractClient;

abstract public class AbstractMessage
{
    private AbstractClient _message;

    public AbstractClient getMessage()
    {
        return this._message;
    }
}
