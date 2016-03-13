package Connection.Message.Parser.Decorators;

import Connection.Message.Parser.RequestMessageQueryParser;

public class RequestMessageQueryCreateParserDecorator extends AbstractRequestMessageQueryParserDecorator
{
    //public static final String LIMIT_LABEL = "limit";

    //public static final int MUST_ERROR_CODE = 201;

    public RequestMessageQueryCreateParserDecorator(RequestMessageQueryParser requestMessageParser)
    {
        super(requestMessageParser);
    }

    public boolean validate()
    {
        return true;
    }

}