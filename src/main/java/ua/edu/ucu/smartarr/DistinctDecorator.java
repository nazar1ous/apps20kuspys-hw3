package ua.edu.ucu.smartarr;

import java.util.ArrayList;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {
    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
        this.smartArray = new BaseArray(getArrayWithoutDuplicates());
    }

    public Object[] getArrayWithoutDuplicates() {
        Object[] tempOld = smartArray.toArray();
        ArrayList<Integer> indexesAdd = new ArrayList<>();
        for (int i = 0; i < tempOld.length - 1; ++i) {
            boolean valid = true;
            for (int j = i + 1; j < tempOld.length; ++j) {
                if (tempOld[i].equals(tempOld[j])) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                indexesAdd.add(i);
            }
        }

        Object[] tempNew = new Object[indexesAdd.size()];
        for (int i = 0; i < indexesAdd.size(); ++i) {
            tempNew[i] = tempOld[indexesAdd.get(i)];
        }
        return tempNew;
    }

    @Override
    public String operationDescription() {
        return "Used Distinct Decorator";
    }
}
