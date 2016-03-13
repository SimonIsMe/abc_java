package Connection.Message.RequestMessageParser.QueryDecorators;

import Connection.Message.RequestMessageParser.RequestMessageQueryParser;
import org.json.JSONObject;

import java.util.LinkedList;

abstract public class AbstractDecorator
{
    private LinkedList<Integer> _errorCodes = new LinkedList<>();
    private RequestMessageQueryParser _requestMessageQueryParser;

    abstract public boolean validate();

    public AbstractDecorator(RequestMessageQueryParser requestMessageParser)
    {
        this._requestMessageQueryParser = requestMessageParser;
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

}
