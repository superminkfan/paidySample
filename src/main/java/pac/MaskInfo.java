package pac;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaskInfo {
    public static void main(String[] args) throws Exception {
        if (args.length > 1)
        {
            System.out.println("More than one argument\ngetting the first one...");
        }

        if (args.length == 0)
        {
            System.out.println("No arguments - return...");
            return;
        }
        String s = action(args[0]);

        if (s.equals(args[0]))
        {
            //made in such a way as not to make the tests smooth
            throw new Exception("Not valid input");
        }
        else
            System.out.println(args[0] + " => " + s);

    }

    /**
     * @param s - string value(email or phone number) to mask
     * @return - masked string or input string in case of exception
     */
    public static String action(String s)  {
        try {
            /**
             * Email regExp
             *
             * common rules:
             * both the local part and the domain name can contain one or more dots,
             * but two dots can not appear right next to each other. Furthermore, the first and last characters in the local part and in the domain name must not be dots;
             * uppercase and lowercase Latin letters A to Z and a to z for both parts;
             * the maximum total length of the local-part or domain part of an email address is 64 octets.
             *
             * rules for local part:
             * digits 0 to 9;
             * printable characters !#$%&'*+-/=?^_`{|}~  ;
             *
             * rules for domain part:
             * digits 0 to 9, provided that top-level domain name has no numeric - only letters;
             * hyphen -, provided that it is not the first or last character;
             * domain names are like secondlevel.com or thirdlevel.secondlevel.com. The top-level domain (.com in these examples) must consist of two to six letters only.
             */
            String emailRegExp = "^^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
            Pattern emailPattern = Pattern.compile(emailRegExp);

            /**
             * Phone regExp
             *
             * maximum length is 13 digits;
             * only one space (‘ ‘) or dash (‘-’) at a time;
             *
             * a phone number consists of at least 9 digits (0-9)
             * and may contain these two characters (‘ ‘, ‘+’)
             * where ‘+’ is only accepted when is the first character.
             * To obfuscate it, spaces (‘ ‘) are converted to dashes (‘-’),
             * any digit is converted to an asterisk (‘*’) except for the last 4, which remain unchanged and the plus sign (‘+’)
             * also remains unchanged (if present). Example: +44 123 456 789 => +**-***-**6-789.
             */
            String phoneRegExp = "^(\\s*)?(\\+)?([^- ]?\\d[- ]?){9,13}(\\s*)?$";

            Pattern phonePattern = Pattern.compile(phoneRegExp);

            s = s.trim();

            Matcher matcher1 = emailPattern.matcher(s);

            if (matcher1.matches()) {
                s = s.toLowerCase();
                int index = s.indexOf("@");
                String localPart = s.substring(0, index);
                String domainPart = s.substring(index);

                if (localPart.length() > 64 || domainPart.length() > 64) {
                    System.out.println("Not valid input");
                    return s;
                }

                char first = localPart.charAt(0);
                char last = localPart.charAt(localPart.length() - 1);

                String result = first + "*****" + last + domainPart;

                return result;
            } else {
                Matcher matcher2 = phonePattern.matcher(s);
                if (matcher2.matches()) {
                    String goodLook = s.replaceAll(" ", "-");

                    String startSub = goodLook.substring(0, s.length() - 4);
                    startSub = startSub.replaceAll("\\d", "*");

                    String endSub = goodLook.substring(s.length() - 4);

                    String result = startSub + endSub;

                    return result;
                } else {
                    System.out.println("Not valid input. s = " + s);
                    return s;
                }
            }
        }
        catch (NullPointerException e)
        {
            e.printStackTrace();
            System.out.println("NullPointerException e = " + e.getMessage());
            return s;
        }
        catch (Exception e)
        {
            e.getStackTrace();
            System.out.println("Exception e = " + e.getMessage());
            return s;
        }
    }
}
