package ua.edu.ucu;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.BaseArray;
import ua.edu.ucu.smartarr.FilterDecorator;
import ua.edu.ucu.smartarr.MapDecorator;
import ua.edu.ucu.smartarr.SmartArray;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };
        Integer[] integers = {-1, 2, 0, 1, -5, 3};
        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        System.out.println(Arrays.toString(sa.toArray()));
//        sa = new FilterDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]
        System.out.println(Arrays.toString(sa.toArray()));
        System.out.println(sa.operationDescription());


    }

}
