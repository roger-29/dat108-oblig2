package no.hvl.dat108;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

public class Validator {

    public static String getErrorMessage(boolean requiresLoginRedirect, boolean invalidPasswordRedirect){
        return (requiresLoginRedirect == true) ? ("You need to log in.")
        : ("Invalid password.");    }

    public static String cleanInput(String input){
        return Jsoup.clean(input, Whitelist.none());
    }

    public static boolean isInvalid(String s){
        return (s.length() == 0 || s == null || isWhitespace(s));
    }

    private static boolean isWhitespace(String s){
        for(int i = 0; i < s.length(); i++){
            if (!Character.isWhitespace(s.charAt(i))) {
                return false;
            }
        }

        return true;
    }

}






