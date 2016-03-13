package Connection.Message.RequestMessageParser.QueryDecorators;

import Connection.Message.RequestMessageParser.RequestMessageQueryParser;

public class CreateDecorator extends AbstractDecorator
{
    //public static final String LIMIT_LABEL = "limit";

    //public static final int MUST_ERROR_CODE = 201;

    public CreateDecorator(RequestMessageQueryParser requestMessageParser)
    {
        super(requestMessageParser);
    }

    public boolean validate()
    {
        return true;
    }

}
