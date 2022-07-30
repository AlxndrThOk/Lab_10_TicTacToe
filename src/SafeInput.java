import java.util.Scanner;


public class SafeInput
{
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString;
        do
        {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        }while(retString.length() == 0);

        return retString;

    }


    public static int getInt(Scanner pipe, String prompt)
    {
        int retInt = 0;
        String trash;
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + ": ");

            if (pipe.hasNextInt())
            {
                retInt = pipe.nextInt();
                pipe.nextLine();
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("Please enter an integer");
            }
        } while (!done);

        return retInt;
    }


    public static double getDouble(Scanner pipe, String prompt)
    {
        double retDouble = 0;
        String trash;
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + ": ");

            if (pipe.hasNextDouble())
            {
                retDouble = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("Please enter an number");
            }
        } while (!done);

        return retDouble;
    }


    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int retInt = 0;
        String trash;
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");

            if (pipe.hasNextInt())
            {
                retInt = pipe.nextInt();
                pipe.nextLine();
                if (low <= retInt && retInt <= high)
                {
                    done = true;
                }
                else
                {
                    System.out.println("Please enter a value between " + low + " and " + high);
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("Please enter an integer");
            }
        } while (!done);

        return retInt;
    }


    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double retDouble = 0;
        String trash;
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");

            if (pipe.hasNextDouble())
            {
                retDouble = pipe.nextDouble();
                pipe.nextLine();
                if (low <= retDouble && retDouble <= high)
                {
                    done = true;
                }
                else
                {
                    System.out.println("Please enter a value between " + low + " and " + high);
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("Please enter an number");
            }
        } while (!done);

        return retDouble;
    }


    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        boolean retBool = true;
        String response;
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + " [Y/N]: ");
            response = pipe.nextLine();
            if (response.equalsIgnoreCase("y"))
            {
                done = true;
            }
            else if (response.equalsIgnoreCase("n"))
            {
                retBool = false;
                done = true;
            }
            else
            {
                System.out.println("Please enter Y or N");
            }
        } while(!done);

        return retBool;
    }


    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String retString;
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
            if (retString.matches(regEx))
            {
                done = true;
            }
            else
            {
                System.out.println("Please enter a string that matches the specified format");
            }
        } while (!done);

        return retString;
    }
}
