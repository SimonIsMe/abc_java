package Config;

import Config.Exceptions.ConfigFileNotFoundException;
import Config.Exceptions.IncorrectConfigKeyNameException;
import Config.Exceptions.ParseConfigFileException;
import org.ini4j.Ini;
import org.ini4j.IniPreferences;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Config
{
    public static final String DIR_PATH = "./src/ConfigIni/";

    private static HashMap<String, Ini> _files = new HashMap<>();
    private static String _namespace = "production";

    public static void setNamespace(String namespace)
    {
        Config._namespace = namespace;
    }

    public static String getNamespace()
    {
        return Config._namespace;
    }

    public static String get(String name) throws ConfigFileNotFoundException, IncorrectConfigKeyNameException, ParseConfigFileException
    {
        String[] parts = Config._getParts(name);

        String filename = DIR_PATH + parts[0] + ".ini";
        File file = Config._getFile(filename);
        Ini ini = Config._getIni(file, filename);

        java.util.prefs.Preferences prefs = new IniPreferences(ini);
        return prefs.node(Config._namespace).get(Config._getKeyName(name), null);
    }

    private static String[] _getParts(String name) throws IncorrectConfigKeyNameException
    {
        if (name.isEmpty())
            throw new IncorrectConfigKeyNameException();

        return name.split("\\.");
    }

    private static Ini _getIni(File file, String filename) throws ParseConfigFileException
    {
        try {
            return new Ini(file);
        } catch (IOException e) {
            throw new ParseConfigFileException(filename);
        }
    }

    private static File _getFile(String filename) throws ConfigFileNotFoundException
    {
        File file = null;
        file = new File(filename);
        if (!file.exists())
            throw new ConfigFileNotFoundException(filename);

        return file;
    }

    private static String _getKeyName(String name)
    {
        return name;

//        String[] parts = name.split("\\.");
//        String toReturn = "";
//        for (int i = 1; i < parts.length; i++) {
//            toReturn += parts[i] + ".";
//        }
//
//        return toReturn.substring(0, toReturn.length() - 1);
    }
}
