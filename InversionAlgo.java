/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coursera;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dushyantrao
 */
public class InversionAlgo {

    static long count = 0;
    static String[] array;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            InversionAlgo obj = new InversionAlgo();
            obj.algo();
        } catch (Exception ex) {
        }
    }

    public void algo() throws Exception {

        BufferedReader bufferedReader =
                new BufferedReader(new FileReader("/Users/dushyantrao/Downloads/IntegerArray.txt"));
        List<String> lines = new ArrayList<String>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();
        array = lines.toArray(new String[lines.size()]);



        String[] outputArray = merge_sort(array);


        System.out.println("Sorted array::::");
        for (int a = 0; a < outputArray.length; a++) {
            System.out.println(outputArray[a]);
        }
        System.out.println("Inversions bitchezzzz-" + count);


    }

    public static String[] merge_sort(String[] _array) throws Exception {

        if (_array.length > 1) {
            String[] Sorted_array = new String[_array.length];
            int mid = _array.length / 2;
            String[] tempLeft = new String[mid];
            String[] tempRight = new String[_array.length - mid];
            
            
            for (int counter = 0; counter < mid; counter++) {
                tempLeft[counter] = _array[counter];
            }
            
            
            for (int counter = mid; counter < _array.length; counter++) {
                tempRight[counter - mid] = _array[counter];
            }
            String[] sortedTempLeft = new String[tempLeft.length];
            sortedTempLeft = merge_sort(tempLeft);
            String[] sortedTempRight = new String[tempRight.length];
            sortedTempRight = merge_sort(tempRight);
            Sorted_array = merge(sortedTempLeft, sortedTempRight);
            return Sorted_array;
        } else {
            // If size is 1, return input array.
            return _array;
        }

    }

    public static String[] merge(String[] _A, String[] _B) throws Exception {
        int i = 0;
        int j = 0;
        int _count = 0;
        String[] _sortedarray = new String[_A.length + _B.length];
        int k = 0;

        while (k < _A.length + +_B.length) {
            if (i < _A.length && j < _B.length) {
// Changed (juthika) : what if both are equal? I added an <= here. (But this wasn't really the cause of the error)
// But this wouldn't work for something like this 3 1 4 2 5 3 8 7
                if (Integer.parseInt(_A[i]) < Integer.parseInt(_B[j])) {
                    _sortedarray[k] = _A[i];
                    i++;
                    k++;
// Here else if is not really required, just else would do
                } else { //if (Integer.parseInt(_A[i]) > Integer.parseInt(_B[j])){
                    _sortedarray[k] = _B[j];
                    j++;
                    _count += (_A.length - i);
                    k++;
                }
            } else {
                if (i >= _A.length) {
                    if (j < _B.length) {
                        _sortedarray[k] = _B[j];
                        k++;
                        j++;
                    }
                }
                if (j >= _B.length) {
                    if (i < _A.length) {
                        _sortedarray[k] = _A[i];
                        i++;
                        k++;
                    }
                }
            }
        }
        count += _count;
        return _sortedarray;
    }
}
