//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String A = sc.next();
                    String B = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.UncommonChars(A, B));
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    String UncommonChars(String str1, String str2)
    {
        // code here
        int MAX_CHAR = 26;
        int present[] = new int[MAX_CHAR];
        for (int i = 0; i < MAX_CHAR; i++)
        {
            present[i] = 0;
        }
 
        int l1 = str1.length();
        int l2 = str2.length();
 
        // for each character of str1, mark its
        // presence as 1 in 'present[]'
        for (int i = 0; i < l1; i++)
        {
            present[str1.charAt(i) - 'a'] = 1;
        }
 
        // for each character of str2
        for (int i = 0; i < l2; i++)
        {
             
            // if a character of str2 is also present
            // in str1, then mark its presence as -1
            if (present[str2.charAt(i) - 'a'] == 1
                || present[str2.charAt(i) - 'a'] == -1)
            {
                present[str2.charAt(i) - 'a'] = -1;
            }
             
            // else mark its presence as 2
            else
            {
                present[str2.charAt(i) - 'a'] = 2;
            }
        }
 
        // print all the uncommon characters
        String ans = "";
        for (int i = 0; i < MAX_CHAR; i++)
        {
            if (present[i] == 1 || present[i] == 2)
            {
                 ans += (char)(i + 'a');
            }
        }  
        
        if(ans == "")
            return "-1";
        
        return ans;
    }
}