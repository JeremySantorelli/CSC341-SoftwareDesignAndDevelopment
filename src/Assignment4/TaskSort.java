package Assignment4;

import java.util.Comparator;

/**
 * TaskSort is capable of Taking a data structure of any datatype and sorting it
 *
 * @author Jeremy Santorelli
 */
class TaskSort<Z> {

    private String sortOrder;
    private String sortMethod;
    private final Object dataObject;
    private final String dataStructure;
    private final AlgorithmFactory algorithm;
    private Comparator<Z> comparator;
    long executionTime;

    public TaskSort(Object dataObject, String dataStructure) {
        this.dataObject = dataObject;
        this.dataStructure = dataStructure;
        algorithm = new AlgorithmFactory();
        this.executionTime = 0;
    }

    void setComparator(Comparator<Z> comparator) {
        this.comparator = comparator;
    }

    long getExecutionTime() {
        return executionTime;
    }

    void getData(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    void setAlgorithm(String sortMethod) {
        this.sortMethod = sortMethod;
    }

    public Object sort() {
        long start = System.nanoTime();
        Object temp = algorithm.sort(dataObject, comparator,
                dataStructure, sortOrder, sortMethod);
        long end = System.nanoTime();
        executionTime = end - start;
        return temp;
    }

}
