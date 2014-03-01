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
public class QuickSortP2 {
    int comparisons;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            QuickSortP2 obj = new QuickSortP2();
            obj.algo();
        } catch (Exception ex) {
        }
    }

    public void algo() throws Exception {
/*Test Cases Begin*/
        BufferedReader bufferedReader =
                new BufferedReader(new FileReader("/Users/dushyantrao/Desktop/Coursera/QuickSort.txt"));
        List<String> lines = new ArrayList<String>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();
        String[] array = lines.toArray(new String[lines.size()]);
        
//        String[] array = {"2", "8", "9", "3", "7", "5","10","1", "6","4"};
//        String[] array = {"0", "9", "8", "7", "6", "5", "4", "3", "2", "1"};
//        String[] array = {"1", "11", "5", "15", "2", "999", "3", "2", "98", "765", "8"
//                , "14", "15", "16", "88", "145", "100", "12", "9", "99", "77", "0"};
/*Test Cases End*/        
        String[] Output = QuickSort(array, 0 , array.length-1);
        for(int x = 0; x<Output.length; x++){
            System.out.print(Output[x]+" ");
        }
        System.out.println(comparisons);
    }
    
    public String[] QuickSort(String[] input, int lowPtr, int highPtr){
        int i;
        int pivot;
        
        i = lowPtr+1;
        
            
        if(lowPtr >= highPtr || lowPtr<0){
            return input;
        }
        else{
            //Swap last element and 1st element
            String last = input[highPtr];
            input [highPtr] = input[lowPtr];
            input [lowPtr] = last;
            //continue normal sorting
            pivot = Integer.parseInt(input[lowPtr]);
            comparisons += (highPtr-lowPtr);
                for (int j =lowPtr+1; j<= highPtr; j++){
                    if(Integer.parseInt(input[j]) < pivot ){
                        //Swap routine
                        String temp = input[j];
                        input[j] = input[i];
                        input[i] = temp;
                        //increment pivot position
                        i++;
                    } 
                }
            //Swap out pivot and existing element
            String temp = input[i-1];
            input[i-1] = input[lowPtr];
            input[lowPtr] = temp;
        }
        
            //
        QuickSort(input,lowPtr,i-2);

        QuickSort(input,i,highPtr);
        
        
        return input;
    }
}
