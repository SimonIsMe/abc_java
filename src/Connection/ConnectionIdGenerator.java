package Connection;

public class ConnectionIdGenerator
{
    private String _last;

    private static ConnectionIdGenerator _instance;

    private ConnectionIdGenerator()
    {
    }

    public static ConnectionIdGenerator getInstance()
    {
        if (_instance == null)
            _instance = new ConnectionIdGenerator();

        return _instance;
    }

    public String getLast()
    {
        return this._last;
    }

    public String getNext()
    {
        if (this._last == null) {
            this._last = "0";
            return "0";
        }

        this._last = this.increment(this._last);
        return this._last;
    }

    /**
     * This method increments given String with this lexicographical order: 0, 1, 2, 3, ..., 8, 9, A, B, ..., X, Y, Z
     *
     * @param text
     * @return String
     */
    public String increment(String text)
    {
        char charAt;
        StringBuilder stringBuilder = new StringBuilder(text);

        for (int i = text.length() - 1; i >= 0; i--) {
            charAt = text.charAt(i);
            switch (charAt) {
                case '9':
                    stringBuilder.setCharAt(i, 'A');
                    return stringBuilder.toString();
                case 'Z':
                    stringBuilder.setCharAt(i, '0');
                    break;
                default:
                    stringBuilder.setCharAt(i, ++charAt);
                    return stringBuilder.toString();
            }
        }

        return "0" + stringBuilder.toString();
    }
}