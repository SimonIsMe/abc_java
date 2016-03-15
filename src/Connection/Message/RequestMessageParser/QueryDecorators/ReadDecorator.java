package Connection.Message.RequestMessageParser.QueryDecorators;

import Connection.Message.RequestMessageParser.RequestMessageQueryParser;

public class ReadDecorator extends AbstractDecorator
{
    public static final String LIMIT_LABEL = "limit";
    public static final String FROM_LABEL = "from";
    public static final String MUST_LABEL = "must";
    public static final String SHOULD_LABEL = "should";
    public static final String MUST_NOT_LABEL = "mustNot";

    public static final int MUST_ERROR_CODE = 102;
    public static final int SHOULD_ERROR_CODE = 103;
    public static final int MUST_NOT_ERROR_CODE = 104;
    public static final int LIMIT_ERROR_CODE = 105;
    public static final int FROM_ERROR_CODE = 106;

    public ReadDecorator(RequestMessageQueryParser requestMessageParser, String userId)
    {
        super(requestMessageParser, userId);
    }

    public boolean validate()
    {
        return  this._validateMust() &&
                this._validateShould() &&
                this._validateMustNot() &&
                this._validateLimit() &&
                this._validateFrom();
    }

    private boolean _validateMust()
    {
        return false;
    }

    private boolean _validateShould()
    {
        return false;
    }

    private boolean _validateMustNot()
    {
        return false;
    }

    private boolean _validateLimit()
    {
        int limit = this.getJsonQuery().getInt(LIMIT_LABEL);
        boolean isValidate = this.getJsonQuery().getString(LIMIT_LABEL).equals(limit + "");

        if (isValidate)
            this.addErrorCode(LIMIT_ERROR_CODE);

        return isValidate;
    }

    private boolean _validateFrom()
    {
        int from = this.getJsonQuery().getInt(FROM_LABEL);
        boolean isValidate = this.getJsonQuery().getString(FROM_LABEL).equals(from + "");

        if (isValidate)
            this.addErrorCode(FROM_ERROR_CODE);

        return isValidate;
    }

}
