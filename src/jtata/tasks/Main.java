package jtata.tasks;

import com.sun.jdi.request.ExceptionRequest;

public class Main {

    private static final String INVALID_INPUT_MSG = "Invalid Input!";

    public static int Add(String numbersString) {

        if (numbersString == "")
            return 0;

        String delimiter = "[\n,]";
        int sum = 0;

        try {

            // checking for the delimiter
            if (numbersString.charAt(0) == '/') {

                if ((numbersString.charAt(1) == '/') && (numbersString.charAt(3) == '\n')) {

                    delimiter = "" + numbersString.charAt(2);
                    numbersString = numbersString.substring(4); // slicing the beginning with slashes,delimiter and \n

                } else {

                    System.out.println(INVALID_INPUT_MSG);
                    return -1;
                }

            }

            // splitting the string into numbers
            String[] numbers = numbersString.split(delimiter, -1);

            for (int i = 0; i < numbers.length; i++) {
                sum += Integer.parseInt(numbers[i]);

            }
        } catch (IndexOutOfBoundsException e) {

            System.out.println(INVALID_INPUT_MSG);
            return -1;

        } catch (NumberFormatException e) {

            System.out.println(INVALID_INPUT_MSG);
            return -1;
        }

        return sum;

    }

    public static void main(String[] args) {

    }
}
