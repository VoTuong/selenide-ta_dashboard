package utilities;

public class NumberUtils {
    public static int parseCurrencyToInt(String currencyString) {
        String updateString = currencyString.replaceAll("\\D", "").trim();
        return Integer.parseInt(updateString);
    }
}
