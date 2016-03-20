package Cache;

import Config.Config;
import Config.Exceptions.ConfigFileNotFoundException;
import Config.Exceptions.IncorrectConfigKeyNameException;
import Config.Exceptions.ParseConfigFileException;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;

public class RedisCache implements CacheInterface
{
    private Jedis _jedis;
    private static RedisCache _instance;

    private RedisCache()
    {
        JedisShardInfo shardInfo = this._getConnectionData();
        this._jedis = new Jedis(shardInfo);
    }

    private JedisShardInfo _getConnectionData()
    {
        String host = null;
        int port = 0;
        String password = null;

        try {
            host = Config.get("redis.host");
            port = Integer.parseInt(Config.get("redis.port"));
            password = Config.get("redis.password");
        } catch (ConfigFileNotFoundException | IncorrectConfigKeyNameException | ParseConfigFileException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

        JedisShardInfo shardInfo = new JedisShardInfo(host, port);
        if (!password.isEmpty())
            shardInfo.setPassword(password);

        return shardInfo;
    }

    protected void finalize() throws Throwable
    {
        this._jedis.close();
    }

    public static RedisCache getInstance()
    {
        if (_instance == null)
            _instance = new RedisCache();

        return _instance;
    }

    public boolean exist(String key)
    {
        return this._jedis.exists(key);
    }

    public String get(String key)
    {
        return this._jedis.get(key);
    }

    public boolean set(String key, String value)
    {
        this._jedis.set(key, value);
        return true;
    }

    public boolean delete(String key)
    {
        return this._jedis.del(key) > 0;
    }
}
