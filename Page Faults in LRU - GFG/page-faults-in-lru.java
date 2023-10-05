//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int pages[]= new int[N];
            for(int i = 0; i < N; i++)
                pages[i] = Integer.parseInt(input_line[i]);
            int C = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.pageFaults(N, C, pages));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution{
    
    static class Node{
        int key;
        int val;
        Node prev;
        Node next;
    }
    
    static Node head = new Node();     //insertion from here
    static Node tail = new Node();
    static HashMap <Integer, Node> cache;
    
    static int pageFaults(int N, int C, int pages[]){
        // code here
        cache = new HashMap<Integer, Node>(C);
        head.next = tail;
        tail.prev = head;
        int faultCounter = 0;
        
        for(int page: pages){
            faultCounter = set(page, page, faultCounter, C);
        }
        
        return faultCounter;
    }

    //Function to return value corresponding to the key.
    public static int get(int key)
    {
        // your code here
        int ans = -1;
        Node node = cache.get(key);
        if(node != null){
            ans = node.val;
            remove(node);
            add(node);
        }
        
        return ans;
        
    }

    //Function for storing key-value pair.
    public static int set(int key, int value, int faultCounter, int capacity)
    {
        // your code here
        //before inserting, we will have to check if the element is already present. If it is
        //we have to move it to the back
        
        Node node = cache.get(key);
        if(node != null){
            remove(node);
            node.val = value;
            add(node);
        }
        else{
            if(cache.size() == capacity){
                cache.remove(tail.prev.key);
                remove(tail.prev);
            }
            
            Node new_node = new Node();
            new_node.key = key;
            new_node.val = value;
            
            cache.put(key, new_node);
            add(new_node);
            faultCounter += 1;
        }
        
        return faultCounter;
    }
    
    
    //Adding nodes to our doubly ll
    public static void add(Node node){
        Node head_next = head.next;
        head.next = node;
        node.prev = head;
        node.next = head_next;
        head_next.prev = node;
    }
    
    //Deleting nodes to our doubly ll
    public static void remove(Node node){
        Node next_node = node.next;
        Node prev_node = node.prev;
        
        next_node.prev = prev_node;
        prev_node.next = next_node;
    }
    
}
    