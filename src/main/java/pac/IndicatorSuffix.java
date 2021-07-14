package pac;

public class IndicatorSuffix {
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

        System.out.println(args[0] + " => " + s);
    }

    /**
     * @param arg - integer value
     * @return - a string with the correct ordinal indicator suffix or input string in case of exception
     */
    public static String action(String arg)  {
        try {
            Object o = arg;
            Integer i = Integer.parseInt(String.valueOf(o));

            if ((i >= 4) && (i <= 20))
            {
                return (i + "th");
            }
            else
            {
                String s = o.toString();
                if (s.endsWith("1"))
                {
                    return (i + "st");
                }
                else if (s.endsWith("2"))
                {
                    return (i + "nd");
                }
                else if (s.endsWith("3"))
                {
                    return (i + "rd");
                }
                else {
                    return (i + "th");
                }
            }
        }
        catch (NumberFormatException e)
        {
            System.out.println("NumberFormatException!!!\nNot valid input. arg = " + arg);
            return arg;
        }
        catch (NullPointerException e)
        {
            e.printStackTrace();
            System.out.println("NullPointerException e = " + e.getMessage());
            return arg;
        }
        catch (Exception e)
        {
            e.getStackTrace();
            System.out.println("Exception e = " + e.getMessage());
            return arg;
        }
    }
}
