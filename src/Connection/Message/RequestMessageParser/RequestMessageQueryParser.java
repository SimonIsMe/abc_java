package Connection.Message.RequestMessageParser;

import Connection.Message.RequestMessageParser.QueryDecorators.*;
import org.json.JSONObject;
import Helper.Helper;
import java.util.LinkedList;

public class RequestMessageQueryParser
{
    public static final String TYPE_LABEL = "type";
    public static final String QUERY_ID_LABEL = "queryId";

    public static final String READ_TYPE = "READ";
    public static final String CREATE_TYPE = "CREATE";
    public static final String UPDATE_TYPE = "UPDATE";
    public static final String DELETE_TYPE = "DELETE";

    public static final int TYPE_ERROR_CODE = 1;
    public static final int QUERY_ID_ERROR_CODE = 2;

    private JSONObject _query;

    private LinkedList<Integer> _errorCodes = new LinkedList<>();

    public RequestMessageQueryParser(JSONObject query)
    {
        this._query = query;
    }

    public JSONObject getJsonQuery()
    {
        return this._query;
    }

    public boolean validate()
    {
        boolean isValidate = this._validateType() && this._validateQueryId();

        AbstractDecorator decorator = this._getDecorator();
        isValidate &= decorator.validate();

        this._errorCodes.addAll(decorator.getErrorCodes());
        return isValidate;
    }

    private boolean _validateType()
    {
        String type = this._query.getString(TYPE_LABEL);
        boolean isValidate = Helper.inArray(type, new String[]{READ_TYPE, CREATE_TYPE, UPDATE_TYPE, DELETE_TYPE});

        if (isValidate)
            this._errorCodes.add(TYPE_ERROR_CODE);

        return isValidate;
    }

    public boolean _validateQueryId()
    {
        String queryId = this._query.getString(QUERY_ID_LABEL);
        boolean isValidate = queryId == null;

        if (isValidate)
            this._errorCodes.add(QUERY_ID_ERROR_CODE);

        return isValidate;
    }

    private AbstractDecorator _getDecorator()
    {
        switch (this._query.getString(TYPE_LABEL)) {
            case READ_TYPE:
                return new ReadDecorator(this);
            case CREATE_TYPE:
                return new CreateDecorator(this);
            case UPDATE_TYPE:
                return new UpdateDecorator(this);
            case DELETE_TYPE:
                return new DeleteDecorator(this);
        }

        return null;
    }

}
