package Connection.Message;

import Connection.Message.Exceptions.ParseRequestMessageException;

public class RequestMessage
{
    public RequestMessage()
    {

    }

    public static RequestMessage parse(String message) throws ParseRequestMessageException
    {
        /*

        {
            "sessionId" : "abc123",
            "requestId" : "12341378",
            "queries": [
                {
                    "type" : "READ",
                    "queryId" : "11235",
                    "must" : { ... },
                    "should" : { ... },
                    "mustNot" : { ... },
                    "limit" : 10,
                    "from" : 0
                },
                {
                    "type" : "CREATE",
                    "queryId" : "abc123def456",
                    "modelName" : "User",
                    "parameters": { ... }
                },
                {
                    "type" : "UPDATE",
                    "queryId" : "abc123def456",
                    "modelName" : "User",
                    "modelId" : "123abc",
                    "parameters": { ... }
                },
                {
                    "type" : "DELETE",
                    "queryId" : "abc123def456",
                    "modelName" : "User",
                    "modelId" : "123abc"
                },
            ]
        }

         */
        return new RequestMessage();
    }
}
