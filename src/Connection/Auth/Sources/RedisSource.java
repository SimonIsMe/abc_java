package Connection.Auth.Sources;

import Config.Exceptions.ConfigFileNotFoundException;
import Config.Exceptions.IncorrectConfigKeyNameException;
import Config.Exceptions.ParseConfigFileException;
import Config.Config;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;

public class RedisSource implements SourceInterface
{
    private static RedisSource _instance;
    private Jedis _jedis;

    private RedisSource()
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


    public static RedisSource getInstance()
    {
        if (_instance == null)
            _instance = new RedisSource();

        return _instance;
    }

    public void set(String key, String value)
    {
        this._jedis.set(key, value);
    }

    public boolean isKey(String keyName)
    {
        return this._jedis.exists(keyName);
    }

    public String get(String keyName)
    {
        return this._jedis.get(keyName);
    }

    public boolean delete(String keyName)
    {
        return this._jedis.del(keyName) > 0;
    }
}
