package app.utils;

public class StringFormatUtil {
 
    public enum StringFormat {
        CAMEL,
        CONSTANT,
        DOT,
        KEBAB,
        LOWER,
        LOWER_FIRST,
        NO,
        PARAM,
        PASCAL,
        PATH,
        SENTENCE,
        SNAKE,
        SWAP,
        TITLE,
        UPPER,
        UPPER_FIRST
    };

    public enum FirstCaseFormat {
        LOWER,
        UPPER
    };

    public static String transCaseFirst(String str, FirstCaseFormat caseType) throws Exception {
        String newString = "";
        if (str.length() < 2) {
            throw new Exception("String length too short");
        }
        switch (caseType) {
            case LOWER:
                newString = str.substring(0, 1).toLowerCase();
                break;
            case UPPER:
                newString = str.substring(0, 1).toUpperCase();
                break;
            default:
            throw new Exception("Unknown type of FirstCaseFormat");
        }
        return newString + str.substring(1);
    }

    public static String toLowerFirst(String str) throws Exception {
        return transCaseFirst(str, FirstCaseFormat.LOWER);
    }

    public static String toUpperFirst(String str) throws Exception {
        return transCaseFirst(str, FirstCaseFormat.UPPER);
    }

}
