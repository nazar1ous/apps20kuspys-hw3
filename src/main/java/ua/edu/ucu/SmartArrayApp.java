package ua.edu.ucu;

import java.lang.reflect.Array;
import java.util.Arrays;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

public class SmartArrayApp {

    public static Integer[]
    filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {

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

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new MapDecorator(
                new SortDecorator(
                        new FilterDecorator(sa, pr),
                        cmp),
                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
    findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {
        int REQ_YEAR = 2;
        int REQ_GPA = 4;
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Student) t).getGPA() >= REQ_GPA &&
                        ((Student) t).getYear() == REQ_YEAR;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Student) o1).getSurname()
                        .compareTo(((Student) o2).getSurname());
            }
        };

        MyFunction f = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return ((Student) t).getSurname() +
                        " " + ((Student) t).getName();
            }
        };
        SmartArray smartArray = new BaseArray(students);
        smartArray = new MapDecorator(
                new SortDecorator(
                        new FilterDecorator(
                                new DistinctDecorator(smartArray), pr),
                        cmp),
                f);

        Object[] result = smartArray.toArray();
        return Arrays.copyOf(result, result.length, String[].class);
    }
}
