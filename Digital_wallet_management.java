import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner in = new Scanner(System.in);
        
        int n= in.nextInt();
        int[] users = new int[n];
        int[] balance = new int[101]; //hashing here makes easy retrieval of balance
        
        for(int i=0; i<n; i++){
            int user_Id= in.nextInt();
            users[i] = user_Id; //just to store order of the userId's
            
            int init_amount= in.nextInt();
            balance[user_Id]= init_amount;
        }
        
        int t= in.nextInt();
        for(int i=0; i<t; i++){
            int from_user = in.nextInt();
            int to_user = in.nextInt();
            int amount= in.nextInt();
            
            if(balance[from_user]>=amount){
                balance[from_user] -= amount;
                balance[to_user] += amount;
                System.out.println("Success");
            }
            else{
                System.out.println("Failure");
            }
        }
        
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(balance[users[i]]>balance[users[j]]){
                    int temp= users[i];
                    users[i]= users[j];
                    users[j]= temp;
                }
            }
        }
        
        System.out.println();
        
        for(int i=0; i<n; i++){
            System.out.println(users[i]+" "+balance[users[i]]);
        }
        
    }
}