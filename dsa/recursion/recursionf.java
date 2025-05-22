// package recursion;

//  public class recursionf {
//     public static int countPaths(int i, int j, int n, int m) {
//         if (i==n || j == m) {
//             return 0;
//         }
//         if (i == n-1 && j == m-1) {
//             return 1;
//         }
//         // move downwards
//         int downPaths = countPaths(i+1, j, n, m);
//         // move right
//         int rightPaths = countPaths(i, j+1, n, m);
//         return downPaths + rightPaths;
//     }
//     public static void main(String[] args) {
//         int n = 3, m = 3;
//         System.out.println(countPaths(0, 0, n, m));
//     }

// }

package recursion;

import java.util.ArrayList;

// public class recursionf {
//     public static int placeTiles(int n, int m) {

//         if (n == m) {
//             return 2;
//         }
//         if (n < m) {
//             return 1;
//         }
//         // vertically
//         int vertPlacements = placeTiles(n-m, m);

//         // horizontally
//         int horPlacements = placeTiles(n-1, m);

//         return vertPlacements + horPlacements;
//     }
//     public static void main(String[] args) {
//          int n = 4;
//          int m = 2;
//          System.out.println(placeTiles(n, m));
//     }
// }

// public class recursionf {
//     public static int callGuests(int n) {
//         if (n <= 1) {
//             return 1;
//         }

//         int ways1 = callGuests(n - 1);
//         int ways2 = (n - 1) * callGuests(n - 2);

//         return ways1 + ways2;

//     }

//     public static void main(String[] args) {
//         int n = 4;
//         System.out.println(callGuests(n));
//     }
// }

public class recursionf {
    public static void printSubset(ArrayList<Integer> subset) {
        for (int i = 0; i < subset.size(); i++) {
            System.out.print(subset.get(i) + " ");
        }
        System.out.println();
    }

    public static void findSubsets(int n, ArrayList<Integer> subset) {
        if (n == 0) {
            printSubset(subset);
            return;
        }
        subset.add(n);
        findSubsets(n-1, subset);

        subset.remove(subset.size()-1); 
        findSubsets(n-1, subset);
    }
    public static void main(String[] args) {
        int n = 10;
        ArrayList<Integer> subset = new ArrayList<>();
        findSubsets(n, subset);
    }
}