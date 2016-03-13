package Connection;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConnectionIdGeneratorTest
{

    @Test
    public void testIncrementA() throws Exception
    {
        String incrementedString = ConnectionIdGenerator.getInstance().increment("A");
        assertEquals(incrementedString, "B");
    }

    @Test
    public void testIncrement0() throws Exception
    {
        String incrementedString = ConnectionIdGenerator.getInstance().increment("0");
        assertEquals(incrementedString, "1");
    }

    @Test
    public void testIncrement5() throws Exception
    {
        String incrementedString = ConnectionIdGenerator.getInstance().increment("5");
        assertEquals(incrementedString, "6");
    }

    @Test
    public void testIncrementX() throws Exception
    {
        String incrementedString = ConnectionIdGenerator.getInstance().increment("X");
        assertEquals(incrementedString, "Y");
    }

    @Test
    public void testIncrementY() throws Exception
    {
        String incrementedString = ConnectionIdGenerator.getInstance().increment("Y");
        assertEquals(incrementedString, "Z");
    }

    @Test
    public void testIncrementZ() throws Exception
    {
        String incrementedString = ConnectionIdGenerator.getInstance().increment("Z");
        assertEquals(incrementedString, "00");
    }

    @Test
    public void testIncrementZZZ() throws Exception
    {
        String incrementedString = ConnectionIdGenerator.getInstance().increment("ZZZ");
        assertEquals(incrementedString, "0000");
    }

    @Test
    public void testIncrementZAZ() throws Exception
    {
        String incrementedString = ConnectionIdGenerator.getInstance().increment("ZAZ");
        assertEquals(incrementedString, "ZB0");
    }

    @Test
    public void testIncrementZAA() throws Exception
    {
        String incrementedString = ConnectionIdGenerator.getInstance().increment("ZAA");
        assertEquals(incrementedString, "ZAB");
    }
}