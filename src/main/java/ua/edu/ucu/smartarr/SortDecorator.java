package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;
import java.util.Comparator;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator{
    public SortDecorator(SmartArray smartArray, MyComparator cmp){
        super(smartArray);
        this.smartArray = new BaseArray(Arrays.
                stream(smartArray.toArray()).sorted(cmp).toArray());
    }

    @Override
    public String operationDescription() {
        return "Sort Decorator";
    }
}
