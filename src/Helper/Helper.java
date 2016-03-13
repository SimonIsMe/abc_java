package Helper;

public class Helper
{
    public static boolean inArray(String text, String[] array)
    {
        for (String item : array) {
            if (item.equals(text)) {
                return true;
            }
        }

        return false;
    }
}
