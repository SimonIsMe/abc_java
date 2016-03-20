package Cache;

public interface CacheInterface
{
    public boolean exist(String key);
    public String get(String key);
    public boolean set(String key, String value);
    public boolean delete(String key);

}
