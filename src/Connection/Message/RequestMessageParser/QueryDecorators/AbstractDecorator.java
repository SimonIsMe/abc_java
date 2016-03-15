package Connection.Message.RequestMessageParser.QueryDecorators;

import Connection.Message.RequestMessageParser.RequestMessageQueryParser;
import org.json.JSONObject;

import java.util.LinkedList;

abstract public class AbstractDecorator
{
    private final LinkedList<Integer> _errorCodes = new LinkedList<>();
    private final RequestMessageQueryParser _requestMessageQueryParser;
    private final String _userId;

    abstract public boolean validate();

    public AbstractDecorator(RequestMessageQueryParser requestMessageParser, String userId)
    {
        this._requestMessageQueryParser = requestMessageParser;
        this._userId = userId;
    }

    public LinkedList<Integer> getErrorCodes()
    {
        return this._errorCodes;
    }

    public void addErrorCode(int errorCode)
    {
        this._errorCodes.add(errorCode);
    }

    public RequestMessageQueryParser getRequestMessageParser()
    {
        return this._requestMessageQueryParser;
    }

    public JSONObject getJsonQuery()
    {
        return this._requestMessageQueryParser.getJsonQuery();
    }

    public String getUserId()
    {
        return this._userId;
    }

}
