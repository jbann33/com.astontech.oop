package common.helpers;

public class StringHelper {



    //notes: this checks a string if it is null or empty, returns TRUE, otherwise returns FALSE
    public static boolean isNullOrEmpty(String s) {
        return s == null || s.length() == 0;
    }

    public static String noSpaces(String x) {
        x = x.replaceAll("\\s", "");
        return x;
    }

    public static String toString(int x) {
        Integer.toString(x);
        return Integer.toString(x);
    }

    public static boolean contains(CharSequence str) {
        if (contains(str))
            return true;
        else
            return false;
    }


}
