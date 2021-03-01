import java.util.ArrayList;
import java.util.stream.Stream;

public class ParallelStreamDemo {
    public static void main(String[] args) {
        ArrayList<Double> myList = new ArrayList<>();

        myList.add(7.0);
        myList.add(18.0);
        myList.add(13.0);
        myList.add(5.0);
        myList.add(24.0);

        double productOfSqrtRoots = myList.parallelStream()
                .reduce(1.0,
                        (a, b) -> a * Math.sqrt(b),
                        (a, b) -> a * b);
        System.out.println("result sqrt " + productOfSqrtRoots);
        System.out.println("-------------------------------------------------------------");

        Stream<Double> sqrtRootStrm =
                myList.stream().map(Math::sqrt);


        double productOfSqrRoots = sqrtRootStrm.reduce(1.0, (a, b) -> a * b);

        System.out.println("result sqrt two streams: " + productOfSqrRoots);

    }

}
