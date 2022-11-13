package Utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {

    public static String userName()
    {
        String generatedString = RandomStringUtils.randomAlphabetic(1);
        return ("John Cena " + generatedString);
    }

    public static String userJob()
    {
        String generatedString = RandomStringUtils.randomAlphabetic(5);
        return (generatedString + " Job");
    }
}
