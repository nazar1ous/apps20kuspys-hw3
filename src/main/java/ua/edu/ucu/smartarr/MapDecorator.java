package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

import java.util.Arrays;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator{

    public MapDecorator(SmartArray smartArray, MyFunction f){
        super(smartArray);
        this.smartArray = new BaseArray(Arrays.
                stream(smartArray.toArray()).
                map(f::apply).toArray());
    }

    @Override
    public String operationDescription() {
        return "Map Decorator";
    }
}
