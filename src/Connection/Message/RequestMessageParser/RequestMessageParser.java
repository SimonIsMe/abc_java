package Connection.Message.RequestMessageParser;

import org.json.JSONObject;

import java.util.LinkedList;

public class RequestMessageParser
{
    public static final String SESSION_ID_LABEL = "sessionId";
    public static final String REQUEST_ID_LABEL = "requestId";
    public static final String QUERIES_LABEL = "queries";

    private final String _message;

    private String _sessionId;
    private String _requestId;

    public static final int SESSION_ID_ERROR_CODE = 1;
    public static final int REQUEST_ID_ERROR_CODE = 2;

    private LinkedList<Integer> _errorCodes = new LinkedList<>();

    private JSONObject _json;

    public RequestMessageParser(String message)
    {
        this._message = message;
        this._json = new JSONObject(this._message);
    }

    public String getSessionId()
    {
        return this._sessionId;
    }

    public String getRequestId()
    {
        return this._requestId;
    }

    public boolean validate()
    {
        boolean isValidate = this._validateSessionId() && this._validateRequestId();

        for (Object item : this._json.getJSONArray(QUERIES_LABEL)) {
            JSONObject itemObject = (JSONObject) item;
            RequestMessageQueryParser requestMessageQueryParser = new RequestMessageQueryParser(itemObject);
            isValidate &= requestMessageQueryParser.validate();
        }

        return isValidate;
    }

    public boolean _validateSessionId()
    {
        this._sessionId = this._json.getString(SESSION_ID_LABEL);
        boolean isValidate = this._sessionId == null;

        if (isValidate)
            this._errorCodes.add(SESSION_ID_ERROR_CODE);

        return isValidate;
    }

    public boolean _validateRequestId()
    {
        this._requestId = this._json.getString(REQUEST_ID_LABEL);
        boolean isValidate = this._requestId == null;

        if (isValidate)
            this._errorCodes.add(REQUEST_ID_ERROR_CODE);

        return isValidate;
    }
}