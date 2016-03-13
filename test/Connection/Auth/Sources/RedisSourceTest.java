package Connection.Auth.Sources;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RedisSourceTest
{

    @Before
    public void setUp() throws Exception
    {
        RedisSource.getInstance();
    }

    @Test
    public void testIsKey() throws Exception
    {
        RedisSource.getInstance().set("a", "a");
        assertTrue(RedisSource.getInstance().isKey("a"));
    }

    @Test
    public void testDelete() throws Exception
    {
        RedisSource.getInstance().set("a", "a");
        assertTrue(RedisSource.getInstance().delete("a"));
    }
}