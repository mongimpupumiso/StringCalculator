import java.util.ArrayList;
import java.util.List;


public class StringCalculator {

// 1. Create an add function that can handle up to two integers passed in as a string.

    public int add(String numbers) {
        String[] numbersArray = numbers.split("");
        if (numbersArray.length > 2) {
            throw new RuntimeException("Up to 2 numbers separated by comma (,) are allowed");
        } else {
            for (String number : numbersArray) {
                if (!number.isEmpty()) {
                    Integer.parseInt(number);

                }
            }
        }
        return 0; // Added return
    }

// 2. Modify the add function to handle multiple integers.

    public static int two(String numbers) {
        int returnValue = 0;
        String[] numbersArray = numbers.split(",");
        for (String number : numbersArray) {
            if (!number.trim().isEmpty()) {
                returnValue += Integer.parseInt(number);
            }
        }
        return returnValue;
    }

// 3. Modify the add function so that it can handle new lines between integers.

    public static int three(String numbers) {
        int returnValue = 0;
        String[] numbersArray = numbers.split(",\n");
        for (String number : numbersArray) {
            if (!number.trim().isEmpty()) {
                returnValue += Integer.parseInt(number.trim());
            }
        }
        return returnValue;
    }

// 4. Modify the add function so that it can handle different delimiter.

    public static int four(String numbers) {
        String delimiter = ",\n";
        String numbersWithoutDelimiter = numbers;
        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("//") + 2;
            delimiter = numbers.substring(delimiterIndex, delimiterIndex + 1);
            numbersWithoutDelimiter = numbers.substring(numbers.indexOf("\n") + 1);
        }
        return add(numbersWithoutDelimiter, delimiter);
    }


    private static int add(String numbers, final String delimiter) {
        int returnValue = 0;
        String[] numbersArray = numbers.split(delimiter);
        for (String number : numbersArray) {
            if (!number.trim().isEmpty()) {
                returnValue += Integer.parseInt(number.trim());
            }
        }
        return returnValue;
    }


//5. Modify the add function so that it can handle negative integers.

    private static int five(String numbers,String delimiter) {
        int returnValue = 0;
        String[] numbersArray = numbers.split(delimiter);
        List<Integer> negativeNumbers = new ArrayList<>();
        for (String number : numbersArray) {
            if (!number.trim().isEmpty()) {
                int numberInt = Integer.parseInt(number.trim());
                if (numberInt < 0) {
                    negativeNumbers.add(numberInt);
                }
                returnValue += numberInt;
            }
        }
        if (negativeNumbers.size() > 0) {
            throw new RuntimeException("Negatives not allowed: " + negativeNumbers.toString());
        }
        return returnValue;
    }

//6. Modify the add function so that it ignores integers greater than or equal to 1000.

    private static int six(String numbers,String delimiter) {
        int returnValue = 0;
        String[] numbersArray = numbers.split(delimiter);
        List<Integer> negativeNumbers = new ArrayList<>();
        for (String number : numbersArray) {
            if (!number.trim().isEmpty()) {
                int numberInt = Integer.parseInt(number.trim());
                if (numberInt < 0) {
                    negativeNumbers.add(numberInt);
                } else if (numberInt <= 1000) {
                    returnValue += numberInt;
                }
            }
        }
        if (negativeNumbers.size() > 0) {
            throw new RuntimeException("Negatives not allowed: " + negativeNumbers.toString());
        }
        return returnValue;
    }

    public static void main(String[] args) {
//        System.out.println(add(""));
        System.out.println(two("1,1"));
        System.out.println(three("1\n2,3"));
        System.out.println(four("//4\n142"));
//        System.out.println(five("-1,-2,3,4"));
//        System.out.println(six("//;\n1000,1;2"));
    }
}




