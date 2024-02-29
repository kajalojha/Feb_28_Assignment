package Feb_28_Assignment;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;


public class Q3_Sliding_Window {

    // Method to find the maximum element in each sliding window
    public int[] maxSlidingWindow(int[] a, int k) {
        // Length of the input array
        int n = a.length;

        // Array to store the maximum elements in each sliding window
        int[] r = new int[n - k + 1];

        // Index for the result array
        int ri = 0;

        // Deque to store  elements in the current window
        Deque<Integer> q = new ArrayDeque<>();

        // Loop through each element of the input array
        for (int i = 0; i < a.length; i++) {
            // Remove elements that are out of the current window range
            if (!q.isEmpty() && q.peek() == i - k) {
                q.poll();
            }

            // Remove smaller elements from the back of the deque
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }

            // Add the current element's index to the deque
            q.offer(i);

            // If the window size is reached, store the maximum element of the current window
            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
            }
        }

        // Return the array containing maximum elements of each sliding window
        return r;
    }

    // Main method
    public static void main(String[] args) {
        // Scanner object for user input
        Scanner sc = new Scanner(System.in);

        // Prompt user to enter the window size
        System.out.println("Enter the size of the sliding window:");
        int k = sc.nextInt();

        // Prompt user to enter the size of the array
        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();

        // Array to store elements
        int arr[] = new int[n];

        // Prompt user to enter the elements of the array
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Create an instance of Q3_Sliding_Window class
        Q3_Sliding_Window slidingWindow = new Q3_Sliding_Window();

        // Call the method to find maximum elements in each sliding window
        int[] result = slidingWindow.maxSlidingWindow(arr, k);

        // Print the maximum elements of each sliding window
        System.out.println("Maximum elements in each sliding window:");
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
