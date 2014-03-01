/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coursera;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author dushyantrao
 */
public class kargerMinCut {
    public static void main(String[] args) {
        try {
            kargerMinCut obj = new kargerMinCut();
            obj.algo();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void algo() throws Exception {
        Map<Integer, List<Integer>> graph = new LinkedHashMap<Integer, List<Integer>>();
        BufferedReader bufferedReader =
                new BufferedReader(new FileReader("/Users/dushyantrao/Desktop/Coursera/kargerMinCut.txt"));
        String line;
        while( ( line = bufferedReader.readLine() ) != null ) {
            String[] split = line.trim().split( "(\\s)+" );
            List<Integer> adjList = new ArrayList<Integer>();
            for(int i = 1; i < split.length; i++) {
                adjList.add( Integer.parseInt( split[i] )-1 );
            }
        graph.put( Integer.parseInt( split[0] )-1, adjList );
        }
        
        int minCuts = 100000;
        for(int i=1; i<=10; i++){
            int tmpCuts = minCut(graph);
            minCuts = Math.min(minCuts, tmpCuts);
        }
        System.out.println(minCuts);
        
    }
    
    public int minCut(Map<Integer, List<Integer>> inputGraph){
        Random rnd = new Random();
        while(inputGraph.size()>2){
            //select a vertex at random in the map
            Set<Integer> keySet = inputGraph.keySet();
            Object[] keyArray = keySet.toArray();
            int vertOneIndex = rnd.nextInt(keyArray.length);
            int vertOne = Integer.parseInt(keyArray[vertOneIndex].toString());
            //get the arraylist for that vertex
            //and the thing must still be there
            if(inputGraph.containsKey(vertOne)){
                List<Integer> vertOneList = (List<Integer>) inputGraph.get(vertOne);
            
                //get a vertex from that arraylist
                int vertTwoIndex = rnd.nextInt(vertOneList.size());
                int vertTwo = vertOneList.get(vertTwoIndex);
                //the KV pair has to exist else kya aachaar lagayega?
                //and they can't be equal, the chosen vertices that is
                if(inputGraph.containsKey(vertTwo) && vertOne!= vertTwo){
                    List<Integer> vertTwoList = (List<Integer>) inputGraph.get(vertTwo);
                
                    //now is when the shit gets real
                    //remove that vertex cause we have that key value pair.
                    inputGraph.remove(vertOne);
                    //I need a set cause I am too lazy to iterate to find duplicates >.<

                    Set<Integer> vertTwoSet = new HashSet();
                    vertTwoSet.addAll(vertTwoList);
                    vertTwoSet.addAll(vertOneList);
                    //Remove self loops and the deleted loop
                    vertTwoSet.remove(vertOne);
                    vertTwoSet.remove(vertTwo);
                    
                    vertTwoList.clear();
                    vertTwoList.addAll(vertTwoSet);
                    //replace the vertice two array list with my new merged set and hope this works.
                    inputGraph.put(vertTwo,vertTwoList);                  
                }
            }
        }
        int cuts = inputGraph.values().toArray().length;
        
        return cuts;
    }
}
