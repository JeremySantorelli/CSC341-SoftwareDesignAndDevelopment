package Assignment4;

import java.util.Comparator;

/**
 * A Primitive simple Bubble Sort method
 * @author Jeremy Santorelli
 * @param <Z>
 */
public class SortAlgorithmArrayBubbleAscending<Z> implements SortAlgorithm {

    @Override
    public Object sort(Object dataObject, Comparator c) {
        Z[] tArr = (Z[]) dataObject;
        int i, j, iMin;

        for (j = 0; j < tArr.length; j++) {
            iMin = j;
            for (i = j + 1; i < tArr.length; i++) {
                if (c.compare(tArr[i], tArr[iMin]) < 0) {
                    iMin = i;
                }
            }//end of inner loop

            if (iMin != j) {
                Z temp = tArr[iMin];
                tArr[iMin] = tArr[j];
                tArr[j] = temp;
            }
        }
        return tArr;
    }

}
