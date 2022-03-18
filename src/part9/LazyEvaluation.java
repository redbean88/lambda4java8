package part9;

import java.util.function.Supplier;

public class LazyEvaluation {
    public static void main(String[] args) {
        if( true || returnTrue()){ // Lazy
            System.out.println("Lazy print : didnt print return True");
        }

        if(or(returnTrue() , returnFalse())){
            System.out.println("didnt work Lazy Evaluation");
        }

    }

    public static boolean or(boolean x, boolean y ){
        return x || y;
    }

    public static boolean LazyOr(Supplier<Boolean> x, Supplier<Boolean> y ){
        return x.get() || y.get();
    }

    public  static boolean  returnTrue(){
        System.out.println("return true");
        return true;
    }

    public static boolean returnFalse(){
        System.out.println("return false");
        return false;
    }
}
