package Feb_28_Assignment;

import java.util.Scanner;
import java.util.Stack;

public class Q2_Largest_Rectangle
{
    int Arae(int arr[] ,int n)
    {
        int result = 0;
        for(int i=0 ;i<n;i++)
        {
            int curr = arr[i];
            for(int j = i-1;j>=arr[i] ;j--)
            {
                if(arr[j] >= arr[i])
                {
                    curr = curr + arr[i];
                }
                else
                {
                    break;
                }
            }
            for (int j = i+1;j<n;j++)
            {
                if(arr[j] >= arr[i])
                {
                    curr += arr[i];
                } else
                {
                 break;
                }
            }
            result = Math.max(result, curr);
            }
           return result;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of array:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("enter the element of array : ");
        for(int i=0 ;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        Q2_Largest_Rectangle obj = new Q2_Largest_Rectangle();
        System.out.println(obj.Arae(arr,n));
    }
}
