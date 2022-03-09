package part4;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerMain {
    public static void main(String[] args) {
        BiConsumer<Integer, Double> myDoubleProcesser  =
                (Integer index,Double input) ->
                        System.out.println("index = " + index+"input = "+ input);

        List<Double> inputs = Arrays.asList(1.2,2.2,3.3);
        process(inputs , myDoubleProcesser);
    }

    public static <T> void process(List<T> list , BiConsumer<Integer , T> processor){
        for (int i = 0; i < list.size(); i++) {
            processor.accept(i , list.get(i));
        }
    }
}
