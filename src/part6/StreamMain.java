package part6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMain {
    public static void main(String[] args) {
        //기본 사용법.
        Stream<String> stringStream = Stream.of("a", "b", "c");
        List<String> stringList1 = stringStream.collect(Collectors.toList());
        System.out.println("stringList1 = " + stringList1);

        //array to list
        String[] strarray = {"a","b","c"};
        Stream<String> strstream = Arrays.stream(strarray);
        List<String> stringList2 = strstream.collect(Collectors.toList());
        System.out.println("stringList2 = " + stringList2);

        //set to list
        Set<Integer> intSet = new HashSet<>(Arrays.asList(1,2,3,4));
        Stream<Integer> intstream = intSet.stream();
        List<Integer> integerList = intstream.collect(Collectors.toList());
        System.out.println("integerList = " + integerList);

    }
}
