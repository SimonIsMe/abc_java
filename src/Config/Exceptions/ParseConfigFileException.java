package Config.Exceptions;

public class ParseConfigFileException extends ConfigExceptions
{
    private final String _fileName;

    public ParseConfigFileException(String fileName)
    {
        this._fileName = fileName;
    }

    public String getMessage()
    {
        return "Wystąpił problem podczas parsowania pliku " + this._fileName + ".";
    }
}
