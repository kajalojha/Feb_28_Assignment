package Feb_28_Assignment;

import java.util.Scanner;
import java.util.Stack;

public class Q1_SimplifyPath {

    public static String simplifyPath(String path) {
        // Split the path into individual directories
        String[] dirs = path.split("/");
        // Create a stack to track the directories
        Stack<String> stack = new Stack<>();

        // Iterate through each directory in the path
        for (String dir : dirs) {
            // If the directory is "..", pop the top directory from stack if it's not empty
            if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            // If the directory is not empty or ".", push it onto the stack
            else if (!dir.equals("") && !dir.equals(".")) {
                stack.push(dir);
            }
        }

        // If the stack is empty, return root directory
        if (stack.isEmpty()) {
            return "/";
        }

        // Build the simplified path using directories in the stack
        StringBuilder ans = new StringBuilder();
        for (String dir : stack) {
            ans.append("/").append(dir);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String path = sc.nextLine();
        System.out.println(simplifyPath(path));
    }
}
