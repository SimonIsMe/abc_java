package Connection.Client;

public interface ClientInterface
{
    public void send(String message);

    public void onClose();
}
