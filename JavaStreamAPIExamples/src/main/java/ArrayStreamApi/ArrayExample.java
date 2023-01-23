package ArrayStreamApi;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

public class ArrayExample {

    public static void main(String[] args) {


        List<Integer> integerList = Arrays.asList(10,205,10,35,40,60,80,4,1,3,5,9,7,8,0);

        //Exercise 1: Sum of all numbers.
        sumOfAllNumbers(integerList);

        //Exercise 2: Average all numbers.
        averageAllNumbers(integerList);

        //Exercise 3: Square, filter >100 and average.
        squareFilterAndAverage(integerList);

        //Exercise 4: Even and Odd numbers.
        evenAndOddNumbers(integerList);

        //Exercise 5: Get numbers starting with 2
        getNumbersStartsWith2(integerList);

        //Exercise 6: Get Duplicate Numbers
        getDuplicateNumbers(integerList);

        //Exercise 7: Get Max and Min Values
        getMaxAndMin(integerList);

        //Exercise 8: Sort values(ASC To DSC)
        sortList(integerList);


    }

    private static void sumOfAllNumbers(List<Integer> integerList) {
        //First Way
        Optional<Integer> sumOfAllNumbers = integerList.stream().reduce(Integer::sum);
        System.out.println(sumOfAllNumbers);
        //Second Way:
        Optional<Integer> sumOfAllNumbers2 = integerList.stream().reduce((a,b) -> a+b);
        System.out.println(sumOfAllNumbers2);

    }

    private static void averageAllNumbers(List<Integer> integerList) {

        double average = integerList.stream().mapToInt(a -> a ).average().orElse(0);
        System.out.println(average);
    }

    private static void squareFilterAndAverage(List<Integer> integerList) {

        double average = integerList.stream().map(a -> a*a).filter(num -> num >100).mapToInt(a ->a).average().orElse(0);
        System.out.println(average);

    }

    private static void evenAndOddNumbers(List<Integer> integerList) {

        List<Integer> evenNumbers = integerList.stream().filter(num -> num % 2 ==0).collect(Collectors.toList());
        System.out.println(evenNumbers);

        List<Integer> oddNumbers = integerList.stream().filter(num -> num % 2 != 0).collect(Collectors.toList());
        System.out.println(oddNumbers);

    }

    private static void getNumbersStartsWith2(List<Integer> integerList) {
        //Sayıları direk sayıyla başlayacak şekilde ayırma yapılamıyor. Stringe dönüştürmen gerek.
        List<Integer> startWith2 = integerList.stream()
                .map(num -> String.valueOf(num))
                .filter(num -> num.startsWith("2"))
                .map(num -> Integer.valueOf(num))
                .collect(Collectors.toList());
        System.out.println(startWith2);

    }

    private static void getDuplicateNumbers(List<Integer> integerList) {

        Set<Integer> getDuplicatedNumbers = integerList.stream()
                .filter(num -> Collections.frequency(integerList, num) > 1)
                .collect(Collectors.toSet());

        System.out.println(getDuplicatedNumbers);


        //WAY2
        Set<Integer> duplicate =  new HashSet<>();
        Set<Integer> duplicate2 = integerList.stream().filter(num -> !duplicate.add(num)).collect(Collectors.toSet());
        System.out.println(duplicate2);
    }

    private static void getMaxAndMin(List<Integer> integerList) {
        int max = integerList.stream().max(Comparator.comparing(Integer::intValue)).get();
        System.out.println(max);
    }

    private static void sortList(List<Integer> integerList) {
        List<Integer> sortedList = integerList.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedList + "ASC List");

        List<Integer> DESCSortedList = integerList.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        System.out.println(DESCSortedList);
    }

}
