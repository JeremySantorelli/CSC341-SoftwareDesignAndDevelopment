package Assignment4;

import java.util.Comparator;

/**
 * A primitive factory to start sorting different data structures with different
 * dataTypes
 *
 * @author Jeremy Santorelli
 */
class AlgorithmFactory<Z> {

    SortAlgorithm s;

    public Object sort(Object list, Comparator<Z> comp, String dataStructure,
            String sortOrder, String sortMethod) {

        //I think this could be done more efficiently
        String concatAllParams = dataStructure + sortMethod + sortOrder;

        switch (concatAllParams) {
            case "arraybubbleascending":
                s = new SortAlgorithmArrayBubbleAscending();
                break;
            case "arraylistbubbleascending":
                s = new SortAlgorithmListBubbleAscending();
                break;
            default:
                s = null;
        }
        if (s != null) {
            return s.sort(list, comp);
        } else {
            return null;
        }

    }
}
