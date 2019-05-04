package Assignment4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Jeremy Santorelli
 * @param <Z>
 */
public class SortAlgorithmListBubbleAscending<Z> implements SortAlgorithm {

    @Override
    public Object sort(Object dataObject, Comparator c) {

        List<Z> tList = (ArrayList<Z>) dataObject;

        int i, j, iMin;

        for (j = 0; j < tList.size(); j++) {
            iMin = j;
            for (i = j + 1; i < tList.size(); i++) {
                if (c.compare(tList.get(i), tList.get(iMin)) < 0) {
                    iMin = i;
                }
            }//end of inner loop

            if (iMin != j) {
                Z temp = tList.get(iMin);
                tList.set(iMin, tList.get(j));
                tList.set(j, temp);
            }
        }
        return tList;
    }

}
