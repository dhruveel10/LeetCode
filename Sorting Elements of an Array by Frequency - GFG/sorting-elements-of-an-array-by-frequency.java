/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
 
    	Scanner scan = new Scanner(System.in);
     
        int no = scan.nextInt();
         
        for(int i=0;i<no;i++){
            
            int size = scan.nextInt();
            int[] arr = new int[size];
            for(int j=0;j<size;j++){
                arr[j] = scan.nextInt();
            }
            sortByFrequency(arr);
            
        }
        scan.close();
    }
    
    public static void sortByFrequency(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        
        for(int i = 0; i<nums.length; i++){
            if(map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i])+1);
            else
                map.put(nums[i], 1);
        }
        
        List<Integer> list = new ArrayList<Integer>(map.keySet());
        
        Collections.sort(list, (a,b) ->{
            if(map.get(a) == map.get(b))
                return a - b;
            else
                return map.get(b) - map.get(a);
        });
        
        int result[] = new int[nums.length];
        int index = 0;
        
        for(int num:list){
            for(int i = 0; i < map.get(num); i++)
                result[index++] = num;
        }
        
        for(int i:result)
            System.out.print(i + " ");
            
        System.out.println();
    }
}