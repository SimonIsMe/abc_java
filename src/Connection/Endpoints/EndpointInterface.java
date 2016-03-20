package Connection.Endpoints;

public interface EndpointInterface
{
    public static final String PING_MESSAGE = "PING";
    public static final String PONG_MESSAGE = "PONG";

    public void start(int port);
    public void stop();
}
