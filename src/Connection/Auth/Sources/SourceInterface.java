package Connection.Auth.Sources;

public interface SourceInterface
{
    public boolean isKey(String keyName);
    public String  get(String keyName);
    public boolean delete(String keyName);
}
