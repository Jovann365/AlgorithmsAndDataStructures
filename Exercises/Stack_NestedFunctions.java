package Exercises;
import java.util.*;
import DataStructures.Stack.*;
import DataStructures.Stack.Stack;

/*
Which function has the most nested function. It could be main !!!!!
Input:
10
call a
call b
return
call c
return
call e
call r
return
return
return
Output:
a

Input:
10
call a
return
call b
return
call c
return
call d
call e
return
return
Output:
main
 */

public class Stack_NestedFunctions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> functions = new LinkedStack<>();
        List<String> names = new ArrayList<>();
        names.add("main");
        List<Integer> nestedFunc = new ArrayList<>();
        nestedFunc.add(0);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String action = sc.next();
            if (action.equals("call")) {
                String func = sc.next();
                names.add(func);
                nestedFunc.add(0);
                functions.push(func);
            } else if (action.equals("return")) {
                functions.pop();
                if (functions.isEmpty()) {
                    nestedFunc.set(0, nestedFunc.getFirst() + 1);
                } else {
                    String name = functions.peek();
                    int index = names.indexOf(name);
                    nestedFunc.set(index, nestedFunc.get(index) + 1);
                }
            }
        }
        int biggestIndex = 0;
        int biggest = nestedFunc.getFirst();
        for (int i = 1; i < nestedFunc.size(); i++) {
           if (nestedFunc.get(i) > biggest) {
               biggest = nestedFunc.get(i);
               biggestIndex = i;
           }
        }
        System.out.println(names.get(biggestIndex));
    }
}
