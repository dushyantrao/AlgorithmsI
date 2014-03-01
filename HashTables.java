/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coursera;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

/**
 *
 * @author dushyantrao
 */
public class HashTables {
    

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Hashtable d = new Hashtable();
        int N = 500000;

        int[] keys = new int[N];
        int count = 0;
        BufferedReader br = new BufferedReader(new FileReader("/Users/dushyantrao/Desktop/Coursera/HashInt.txt"));
        String str;
        int k = 0;

        // store all numbers in an array as well as hash them into a hash table
        while((str = br.readLine()) != null){
            keys[k] = Integer.parseInt(str);
            d.put(new Integer(keys[k]), new Integer(keys[k]));
            k++;
        }
        br.close();
        
        for(int i=2500; i<=4000; i++){
            count += TwoSum(i,d,keys);
        }
        System.out.println(count);
    }
    
    public static int TwoSum(int sum, Hashtable d, int[]keys){
        int count=0;
        for (int i=0; i<keys.length; i++){

            // if (sum-ele) is present in the hash table, you have found a match
            if(d.containsKey(sum - keys[i]) && keys[i] != (sum - keys[i])) {
                count++; 
                break;
            }
        }
        
        
        return count;        
    }
    
}
