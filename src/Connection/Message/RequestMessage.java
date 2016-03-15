package Connection.Message;

import Connection.Message.Exceptions.ParseRequestMessageException;
import Connection.Connection;
import Connection.Message.RequestMessageParser.RequestMessageParser;
import org.json.JSONObject;

public class RequestMessage
{
    private final JSONObject _json;
    private final Connection _connection;

    public RequestMessage(JSONObject json, Connection connection)
    {
        this._json = json;
        this._connection = connection;
    }

    public static RequestMessage parse(String message, Connection connection) throws ParseRequestMessageException
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

        RequestMessageParser requestMessageParser = new RequestMessageParser(message, connection);
        if (!requestMessageParser.validate()) {
            _sendErrorMessage(requestMessageParser, connection);
        }

        return new RequestMessage(requestMessageParser.getJson(), connection);
    }

    private static void _sendErrorMessage(RequestMessageParser requestMessageParser, Connection connection)
    {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setStatus(ResponseMessage.VALIDATE_ERROR_STATUS);
        connection.send(responseMessage);
    }
}
