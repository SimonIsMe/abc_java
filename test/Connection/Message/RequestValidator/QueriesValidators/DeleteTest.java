package Connection.Message.RequestValidator.QueriesValidators;

import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DeleteTest
{

    @Before
    public void setUp() throws Exception
    {

    }

    @After
    public void tearDown() throws Exception
    {

    }

    @Test
    public void testValidate() throws Exception
    {
        JSONObject json = new JSONObject(
                "{ \"type\" : \"" + Delete.TYPE + "\",\n" +
                "    \"queryId\" : \"abc123def456\"," +
                "    \"modelName\" : \"User\"," +
                "    \"modelId\" : \"123abc\"" +
                "}");

        Delete deleteQuery = new Delete(json);
        assertTrue(deleteQuery.validate());
    }
}