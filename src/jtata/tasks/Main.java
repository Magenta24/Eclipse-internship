package jtata.tasks;

public class Main {

    public static int Add(String numbersString) {
        if(numbersString == "")
            return 0;

        String[] numbers = numbersString.split(",");
        int sum = 0;

        for(int i=0;i<numbers.length;i++) {
            sum += Integer.parseInt(numbers[i]);
        }

        return sum;
    }

    public static void main(String[] args) {

    }
}
