package jtata.tasks;

public class Main {

    public static int Add(String numbersString) {
        if(numbersString == "")
            return 0;

        String[] numbers = numbersString.split(",");
        int sum = 0;

        if(numbers.length == 1)
            sum = Integer.parseInt(numbers[0]);
        else
            sum = Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);

        return sum;
    }

    public static void main(String[] args) {
        
    }
}
