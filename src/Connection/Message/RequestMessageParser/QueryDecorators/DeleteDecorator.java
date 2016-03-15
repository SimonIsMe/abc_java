package Connection.Message.RequestMessageParser.QueryDecorators;

import Connection.Message.RequestMessageParser.RequestMessageQueryParser;

public class DeleteDecorator extends AbstractCreateUpdateDeleteDecorator
{
    //public static final String LIMIT_LABEL = "limit";

    //public static final int MUST_ERROR_CODE = 201;

    public DeleteDecorator(RequestMessageQueryParser requestMessageParser, String userId)
    {
        super(requestMessageParser, userId);
    }

    public boolean validate()
    {
        return super.validate();
    }

}
