package Config.Exceptions;

public class ConfigFileNotFoundException extends ConfigExceptions
{
    private final String _fileName;

    public ConfigFileNotFoundException(String fileName)
    {
        this._fileName = fileName;
    }

    public String getMessage()
    {
        return "Plik konfiguracyjny " + this._fileName + " nie istnieje";
    }
}
