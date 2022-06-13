package jtata.tasks;

import com.sun.jdi.request.ExceptionRequest;

public class Main {

    private static final String INVALID_INPUT_MSG = "Invalid Input!";

    public static int Add(String numbersString) throws Exception {

        if (numbersString == "")
            return 0;

        String delimiter = "[\n,]";     // default delimiter
        int sum = 0;
        boolean isNegative = false;     // task 5 - indicating if negative numbers occurred
        String negativeNumMsg = "";     // message for the exception

        try {

            // checking for the delimiter
            if (numbersString.charAt(0) == '/') {

                // returning -1 if after first slash there is no /[delimiter]\n
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


            int number;     // a single number from the string
            for (int i = 0; i < numbers.length; i++) {

                number = Integer.parseInt(numbers[i]);

                // task 5 - check if the number is negative and creating a message
                if (number < 0) {

                    if (isNegative == false) {
                        isNegative = true;
                        negativeNumMsg += "negatives not allowed: ";
                    }

                    negativeNumMsg = negativeNumMsg + number + " ";
                    continue;
                }

                // task 6 - ignoring numbers greater than 1000
                if (number > 1000)
                    continue;

                sum += number;

            }

            // task 5 - throwing exception if negative numbers occurred
            if (isNegative == true) {
                throw new Exception(negativeNumMsg);
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
