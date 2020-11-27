package ua.edu.ucu.smartarr;

// Base array for decorators
public class BaseArray implements SmartArray{
    private final Object[] smartArray;

    public BaseArray(Object[] arr){
        this.smartArray = arr.clone();
    }

    public BaseArray(){
        this.smartArray = new Object[0];
    }
    @Override
    public Object[] toArray() {
        return smartArray.clone();
    }

    @Override
    public String operationDescription() {
        return "Base array";
    }

    @Override
    public int size() {
        return smartArray.length;
    }
}
