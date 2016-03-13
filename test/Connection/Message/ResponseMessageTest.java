package Connection.Message;

import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.*;

public class ResponseMessageTest
{
    @Test
    public void testToStringFullMessage() throws Exception
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key", "value");
        ResponseMessage responseMessage = new ResponseMessage(jsonObject, "wiadomość", ResponseMessage.FORBIDDEN_STATUS);

        JSONObject jsonObjectResponse = new JSONObject();
        jsonObjectResponse.put("status", ResponseMessage.FORBIDDEN_STATUS);
        jsonObjectResponse.put("message", "wiadomość");
        jsonObjectResponse.put("data", jsonObject);

        assertEquals(responseMessage.toString(), jsonObjectResponse.toString());
    }

    @Test
    public void testToStringMessageWithDataAndMessage() throws Exception
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key", "value");
        ResponseMessage responseMessage = new ResponseMessage(jsonObject, "wiadomość");

        JSONObject jsonObjectResponse = new JSONObject();
        jsonObjectResponse.put("status", ResponseMessage.OK_STATUS);
        jsonObjectResponse.put("message", "wiadomość");
        jsonObjectResponse.put("data", jsonObject);

        assertEquals(responseMessage.toString(), jsonObjectResponse.toString());
    }

    @Test
    public void testToStringMessageWithData() throws Exception
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key", "value");
        ResponseMessage responseMessage = new ResponseMessage(jsonObject);

        JSONObject jsonObjectResponse = new JSONObject();
        jsonObjectResponse.put("status", ResponseMessage.OK_STATUS);
        jsonObjectResponse.put("data", jsonObject);

        assertEquals(responseMessage.toString(), jsonObjectResponse.toString());
    }

    @Test
    public void testToStringMessageWithMessage() throws Exception
    {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage("wiadomość");

        JSONObject jsonObjectResponse = new JSONObject();
        jsonObjectResponse.put("status", ResponseMessage.OK_STATUS);
        jsonObjectResponse.put("message", "wiadomość");

        assertEquals(responseMessage.toString(), jsonObjectResponse.toString());
    }

    @Test
    public void testToStringMessageWithMessageAndCode() throws Exception
    {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage("wiadomość");
        responseMessage.setStatus(ResponseMessage.ERROR_STATUS);

        JSONObject jsonObjectResponse = new JSONObject();
        jsonObjectResponse.put("status", ResponseMessage.ERROR_STATUS);
        jsonObjectResponse.put("message", "wiadomość");

        assertEquals(responseMessage.toString(), jsonObjectResponse.toString());
    }
}