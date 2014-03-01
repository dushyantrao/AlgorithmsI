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
public class QuickSortP3 {
    int comparisons;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            QuickSortP3 obj = new QuickSortP3();
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
        
//       String[] array = {"2", "8", "9", "3", "7", "5","10","1", "6","4"};
//        String[] array = {"0", "9", "8", "7", "6", "5", "4", "3", "2", "1"};
//        String[] array = {"1", "11", "5", "15", "2", "999", "3", "2", "98", "765", "8"
//                , "14", "15", "16", "88", "145", "100", "12", "9", "99", "77", "0"};
/*Test Cases End*/        
        String[] Output = QuickSort(array, 0 , array.length-1);
        for(int x = 0; x<Output.length; x++){
            System.out.print(Output[x]+" ");
        }
        System.out.println("Comparisons :"+ comparisons);
    }
    
    public String[] QuickSort(String[] input,int lowPtr, int highPtr){
        int i;
        int pivot;
        
        i = lowPtr+1;
        
        if(lowPtr >= highPtr || lowPtr<0){
            return input;
        }
        else{
            //only if array is of size greater than 3
            
                int middle = (lowPtr+highPtr)/2;
                               
                //low mid high
                if(  (Integer.parseInt(input[lowPtr]) <= Integer.parseInt(input[highPtr]))
                   &&(Integer.parseInt(input[lowPtr]) <= Integer.parseInt(input[middle]))
                   &&(Integer.parseInt(input[highPtr]) >= Integer.parseInt(input[middle]))
                        ){
                        String median = input[middle];
                        input[middle] = input[lowPtr];
                        input[lowPtr] = median;
                }
                //high low mid
                if(  (Integer.parseInt(input[lowPtr]) >= Integer.parseInt(input[highPtr]))
                   &&(Integer.parseInt(input[lowPtr]) <= Integer.parseInt(input[middle]))
                   &&(Integer.parseInt(input[highPtr]) <= Integer.parseInt(input[middle]))
                        ){
                        String median = input[lowPtr];
                        input[lowPtr] = input[lowPtr];
                        input[lowPtr] = median;
                }
                //low high mid
                if(  (Integer.parseInt(input[lowPtr]) <= Integer.parseInt(input[highPtr]))
                   &&(Integer.parseInt(input[lowPtr]) <= Integer.parseInt(input[middle]))
                   &&(Integer.parseInt(input[highPtr]) <= Integer.parseInt(input[middle]))
                        ){
                        String median = input[highPtr];
                        input[highPtr] = input[lowPtr];
                        input[lowPtr] = median;
                }
                //high mid low
                if(  (Integer.parseInt(input[lowPtr]) >= Integer.parseInt(input[highPtr]))
                   &&(Integer.parseInt(input[lowPtr]) >= Integer.parseInt(input[middle]))
                   &&(Integer.parseInt(input[highPtr]) <= Integer.parseInt(input[middle]))
                        ){
                        String median = input[middle];
                        input[middle] = input[lowPtr];
                        input[lowPtr] = median;
                }
                
                //mid low high
                if(  (Integer.parseInt(input[lowPtr]) <= Integer.parseInt(input[highPtr]))
                   &&(Integer.parseInt(input[lowPtr]) >= Integer.parseInt(input[middle]))
                   &&(Integer.parseInt(input[highPtr]) >= Integer.parseInt(input[middle]))
                        ){
                        String median = input[lowPtr];
                        input[lowPtr] = input[lowPtr];
                        input[lowPtr] = median;
                }
                //mid high low
                if(  (Integer.parseInt(input[lowPtr]) >= Integer.parseInt(input[highPtr]))
                   &&(Integer.parseInt(input[lowPtr]) >= Integer.parseInt(input[middle]))
                   &&(Integer.parseInt(input[highPtr]) >= Integer.parseInt(input[middle]))
                        ){
                        String median = input[highPtr];
                        input[highPtr] = input[lowPtr];
                        input[lowPtr] = median;
                }
            
            
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
