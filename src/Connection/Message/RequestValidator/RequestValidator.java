package Connection.Message.RequestValidator;

import Connection.Auth.Auth;
import Connection.Auth.Exceptions.SessionIdException;
import Validators.SessionIdValidate;
import org.json.JSONObject;

import java.util.LinkedList;

public class RequestValidator
{
    public static final String SESSION_ID_LABEL = "sessionId";
    public static final String REQUEST_ID_LABEL = "requestId";
    public static final String QUERIES_LABEL = "queries";

    public static final int SESSION_ID_ERROR_CODE = 1;
    public static final int REQUEST_ID_ERROR_CODE = 2;

    private final JSONObject _json;

    private LinkedList<Integer> _errorCodes = new LinkedList<>();

    private String _sessionId;
    private String _requestId;
    private String _userId;

    public RequestValidator(JSONObject json)
    {
        this._json = json;
    }

    public boolean validate()
    {
        boolean isValidate = this._validateSessionId() && this._validateRequestId();
        this._userId = this._getUserId();

        for (Object item : this._json.getJSONArray(QUERIES_LABEL)) {
            JSONObject itemObject = (JSONObject) item;
            QueryValidator queryValidator = new QueryValidator(itemObject);
            isValidate &= queryValidator.validate();
        }

        return isValidate;
    }

    public String getSessionId()
    {
        return this._sessionId;
    }

    public boolean _validateSessionId()
    {
        this._sessionId = this._json.getString(SESSION_ID_LABEL);
        boolean isValidate = this._sessionId != null;

        SessionIdValidate sessionIdValidate = new SessionIdValidate(this._sessionId);

        if (!isValidate || sessionIdValidate.validate())
            this._errorCodes.add(SESSION_ID_ERROR_CODE);

        return isValidate;
    }

    public boolean _validateRequestId()
    {
        this._requestId = this._json.getString(REQUEST_ID_LABEL);
        boolean isValidate = this._requestId != null;

        if (!isValidate)
            this._errorCodes.add(REQUEST_ID_ERROR_CODE);

        return isValidate;
    }

    private String _getUserId()
    {
        try {
            return Auth.getInstance().getUserId(this.getSessionId());
        } catch (SessionIdException e) {
        }
        return "";
    }
}
