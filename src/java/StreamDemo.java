import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(1);
        myList.add(47);
        myList.add(43);
        myList.add(55);
        myList.add(19);
        myList.add(643);
        myList.add(85);
        myList.add(3445);
        myList.add(16);


        System.out.println("Default list" + myList);

        Stream<Integer> myStream = myList.stream();

        Optional<Integer> minVal = myStream.min(Integer::compare);
        minVal.ifPresent(integer -> System.out.println("minimal Value is:" + integer));

        System.out.println("---------------------------");

        myStream = myList.stream();
        Optional<Integer> maxVal = myStream.max(Integer::compare);
        maxVal.ifPresent(integer -> System.out.println("maximum Value is: " + integer));

        System.out.println("---------------------------");

        Stream<Integer> sortedStream = myList.stream().sorted();
        System.out.println("sorted stream ");
        sortedStream.forEach(n -> System.out.println(n + " "));
        System.out.println("----------------------");

        Stream<Integer> oddVal = myList.stream()
                .sorted()
                .filter(integer -> (integer % 2) == 1);

        oddVal.forEach(integer -> System.out.println(integer + " "));
        System.out.println("-------------------------");

        oddVal = myList.stream()
                .filter(integer -> (integer % 2) == 1)
                .filter(integer -> integer > 5);
        System.out.println("Values > 5: ");
        oddVal.forEach(integer -> System.out.println(integer + " "));
        System.out.println("---------------------------");

        Optional<Integer> productObj = myList.stream()
                .reduce((a, b) -> a * b);
        productObj.ifPresent(integer -> System.out.println("Произведение в виде объекта: type Optional " + integer));

        System.out.println("---------------------------");

        int product = myList.stream()
                .reduce(1, (a, b) -> a * b);
        System.out.println("Произведение в виде объекта: type int " + product);

        System.out.println("---------------------------");

        int evenProduct = myList.stream()
                .reduce(1, (a, b) -> {
                    if (b % 2 == 0) return a * b;
                    else return a;
                });
        System.out.println("is even product " + evenProduct);
    }
}
