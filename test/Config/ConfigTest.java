package Config;

import Config.Exceptions.ConfigFileNotFoundException;
import Config.Exceptions.IncorrectConfigKeyNameException;
import Config.Exceptions.ParseConfigFileException;
import org.junit.Test;

import java.io.File;
import java.io.PrintWriter;

import static org.junit.Assert.*;

public class ConfigTest
{

    @org.junit.Before
    public void setUp() throws Exception
    {
        PrintWriter pw = new PrintWriter("./src/ConfigIni/test.ini", "UTF-8");
        pw.println("[production]");
        pw.println("test.wartosc=123");
        pw.println("test.wartosc.wartoscABC=456");
        pw.println("");
        pw.println("; jakiś komentarz");
        pw.println("[development]");
        pw.println("test.wartosc = 78");
        pw.println("test.wartosc.wartoscABC = 90");
        pw.close();

        PrintWriter pw2 = new PrintWriter("./src/ConfigIni/test-zly.ini", "UTF-8");
        pw2.println("aaaa");
        pw2.close();
    }

    @org.junit.After
    public void tearDown() throws Exception
    {
        File file = new File("./src/ConfigIni/test.ini");
        file.delete();

        File file2 = new File("./src/ConfigIni/test-zly.ini");
        file2.delete();
    }

    @org.junit.Test
    public void testGetFirstLevelValue() throws Exception
    {
        Config.setNamespace("production");
        assertEquals(Config.get("test.wartosc"), "123");
    }

    @org.junit.Test
    public void testGetDeepLevelValue() throws Exception
    {
        Config.setNamespace("production");
        assertEquals(Config.get("test.wartosc.wartoscABC"), "456");
    }

    @org.junit.Test
    public void testGetFirstLevelValueFromDevelpment() throws Exception
    {
        Config.setNamespace("development");
        assertEquals(Config.get("test.wartosc"), "78");
    }

    @org.junit.Test
    public void testGetNotExistValue() throws Exception
    {
        Config.setNamespace("production");
        assertNull(Config.get("test.wartoscNieistniejaca"));
    }

    @Test(expected=IncorrectConfigKeyNameException.class)
    public void testEmptyKeyName() throws Exception
    {
        Config.setNamespace("production");
        Config.get("");
    }

    @Test(expected=ConfigFileNotFoundException.class)
    public void testIncorrectKeyName() throws Exception
    {
        Config.setNamespace("production");
        Config.get("jakas.nieistniejaca.wartosc");
    }

    @Test(expected=ParseConfigFileException.class)
    public void testParseConfigException() throws Exception
    {
        Config.setNamespace("production");
        Config.get("test-zly.nieistniejaca.wartosc");
    }
}