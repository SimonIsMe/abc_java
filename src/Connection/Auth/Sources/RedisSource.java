package Connection.Auth.Sources;

import Cache.RedisCache;

public class RedisSource implements SourceInterface
{
    private static RedisSource _instance;
    private final RedisCache _redisCache;

    private RedisSource()
    {
        this._redisCache = RedisCache.getInstance();
    }

    public static RedisSource getInstance()
    {
        if (_instance == null)
            _instance = new RedisSource();

        return _instance;
    }

    public void set(String key, String value)
    {
        this._redisCache.set(key, value);
    }

    public boolean isKey(String keyName)
    {
        return this._redisCache.exist(keyName);
    }

    public String get(String keyName)
    {
        return this._redisCache.get(keyName);
    }

    public boolean delete(String keyName)
    {
        return this._redisCache.delete(keyName);
    }
}
