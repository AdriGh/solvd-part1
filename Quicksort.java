import java.util.Scanner;
import java.util.ArrayList;

public class Quicksort {
    static int i;
    static int nxtInt;
    static ArrayList<Integer> numArr = new ArrayList<Integer>(); // New Array List
    static ArrayList<Integer> left = new ArrayList<Integer>();
    static ArrayList<Integer> right = new ArrayList<Integer>();
    static ArrayList<Integer> pivot = new ArrayList<Integer>();

    public static void sortLeft() {
        int i = 0;
        ArrayList<Integer> leftArr = new ArrayList<Integer>();
        ArrayList<Integer> rightArr = new ArrayList<Integer>();
        ArrayList<Integer> backup = new ArrayList<Integer>();

        pivot.clear(); // We clear the full array Pivot
        pivot.add(left.get(0)); // And we set the left part Array pivot
        System.out.println("Este es el pivot left: " + pivot);
        do {
            if (pivot.get(0) > left.get(i)) {
                leftArr.add(left.get(i));
            } else {
                if (pivot.get(0) < left.get(i)) {
                    rightArr.add(left.get(i));
                }
            }
            i++;
        } while (left.size() > i);

        if (leftArr.get(0) > leftArr.get(1)) {
            backup.add(leftArr.get(0));
            leftArr.remove(0);
            leftArr.add(backup.get(0));
            backup.clear();
        } else {
            if (rightArr.get(0) > rightArr.get(1)) {
                backup.add(rightArr.get(0));
                rightArr.remove(0);
                rightArr.add(backup.get(0));
                backup.clear();
            }
        }

        left.clear();
        left.addAll(leftArr);
        left.addAll(pivot);
        left.addAll(rightArr);
        System.out.println("Sorted left array: " + left);
    }

    public static void sortRight() {
        int i = 0;
        ArrayList<Integer> leftArr = new ArrayList<Integer>();
        ArrayList<Integer> rightArr = new ArrayList<Integer>();
        ArrayList<Integer> backup = new ArrayList<Integer>();

        pivot.clear(); // We clear the full array Pivot
        pivot.add(right.get(0)); // And we set the left part Array pivot
        System.out.println("Este es el pivot right: " + pivot);

        do {
            if (pivot.get(0) > right.get(i)) {
                leftArr.add(right.get(i));
            } else {
                if (pivot.get(0) < right.get(i)) {
                    rightArr.add(right.get(i));
                }
            }
            i++;
        } while (right.size() > i);

        leftArr.add(1, 1);
        if (leftArr.get(0) > leftArr.get(1)) {
            leftArr.remove(1);
            backup.add(leftArr.get(0));
            leftArr.remove(0);
            leftArr.add(backup.get(0));
            backup.clear();
        }

        right.clear();
        right.addAll(leftArr);
        right.addAll(pivot);
        right.addAll(rightArr);
        System.out.println("Sorted right array: " + right);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // New Scanner

        do {
            System.out.println("Add a number to Array:");
            int nxtInt = sc.nextInt();
            numArr.add(nxtInt);
            System.out.println("[ " + numArr.size() + " - 7 ]");
        } while (numArr.size() < 7);
        System.out.println("Array: " + numArr);
        // Already have a 7 element Array.

        pivot.add(numArr.get(0));

        do {
            if (pivot.get(0) > numArr.get(i)) {
                left.add(numArr.get(i));
            } else {
                if (pivot.get(0) < numArr.get(i)) {
                    right.add(numArr.get(i));
                }
            }
            i++;
        } while (numArr.size() > i);

        System.out.println("Left Array: " + left);
        System.out.println("Right Array: " + right);
        // Sort left part
        sortLeft();
        sortRight();
        System.out.println("Sorted array: " + left + " " + numArr.get(0) + " " + right);
    }
}