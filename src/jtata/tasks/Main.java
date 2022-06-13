package jtata.tasks;

public class Main {

    public static int Add(String numbersString) {
        if(numbersString == "")
            return 0;

        String[] numbers = numbersString.split("[\n,]",-1);
        int sum = 0;

        try {

            for(int i=0;i<numbers.length;i++) {
                sum += Integer.parseInt(numbers[i]);
            }
//            System.out.println(numbers.length);
            return sum;

        }catch (NumberFormatException e) {

            System.out.println("Invalid input!");
            return -1;
        }

    }

    public static void main(String[] args) {
//        System.out.println(Add("2\n,"));
//        System.out.println(Add("22,,"));
    }
}
