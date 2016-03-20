package Connection.Message;

import org.json.JSONObject;

public class ResponseMessage
{
    public static final int OK_STATUS = 200;
    public static final int ERROR_STATUS = 500;
    public static final int VALIDATE_ERROR_STATUS = 402;
    public static final int FORBIDDEN_STATUS = 403;
    public static final int NOT_FOUND_STATUS = 404;
    public static final int OVERFLOW_CONNECTIONS_STATUS = 405;
    public static final int PROJECT_NOT_FOUND_STATUS = 406;

    private int _status = OK_STATUS;
    private JSONObject _data;
    private String _message;

    public ResponseMessage(JSONObject data, String message, int status)
    {
        this._message = message;
        this._data = data;
        this._status = status;
    }

    public ResponseMessage(JSONObject data, String message)
    {
        this._message = message;
        this._data = data;
    }

    public ResponseMessage(JSONObject data)
    {
        this._data = data;
    }

    public ResponseMessage()
    {
    }

    public int getStatus()
    {
        return this._status;
    }

    public void setStatus(int _status)
    {
        this._status = _status;
    }

    public JSONObject getData()
    {
        return this._data;
    }

    public void setData(JSONObject _data)
    {
        this._data = _data;
    }

    public String getMessage()
    {
        return this._message;
    }

    public void setMessage(String _message)
    {
        this._message = _message;
    }

    public String toString()
    {
        JSONObject toReturn = new JSONObject();

        toReturn.put("status", this._status);
        toReturn.put("message", this._message);
        toReturn.put("data", this._data);

        return toReturn.toString();
    }
}
