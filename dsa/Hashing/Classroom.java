package Hashing;

import java.util.HashMap;

public class Classroom {
    public static void majorityElement(int nums[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (int key : map.keySet()) {
            if (map.get(key) > n / 3) {
                System.out.println(key);
            }
        }
    }

    public static void union(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums1.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums1[i])) {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            } else {
                map.put(nums1[i], 1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                map.put(nums2[i], map.get(nums2[i]) + 1);
            } else {
                map.put(nums2[i], 1);
            }

        }
        for (int key : map.keySet()) {
            System.out.println(key);
        }
        System.out.print("The size of union is : ");
        System.out.println(map.size());
    }

    public static void intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums1.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums1[i])) {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            } else {
                map.put(nums1[i], 1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                System.out.println(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }

        }
        System.out.print("The number of intersection is : ");
        System.out.println(map.size());
    }

    public static String getStart(HashMap<String , String> tick) {
        HashMap<String, String> revMap = new HashMap<>();
        for (String key : tick.keySet()) {
            revMap.put(tick.get(key), key);
        }
        for (String key : tick.keySet()) {
            if (!revMap.containsKey(key)) {
                return key;
            }
        }
        return null;
    }

    

    public static void main(String[] args) {
        // int nums[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };
        // int nums1[] = { 7, 3, 9 };
        // int nums2[] = { 6, 3, 9, 2, 9, 4 };
        // HashMap<String, String> tickets = new HashMap<>();
        // tickets.put("Chennai", "Bengauluru");
        // tickets.put("Mumbai", "Delhi");
        // tickets.put("Goa", "Chennai");
        // tickets.put("Delhi", "Goa");

        int arr[] = {10, 2, -2, -20, 10};
        int k = -10;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }

            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);    
            } else {
                map.put(sum, 1);
            }
        }
        System.out.println(ans);
                   

        // String start = getStart(tickets);
        // while (tickets.containsKey(start)) {
        //     System.out.print(start + " -> ");
        //     start = tickets.get(start);
        // }
        // System.out.println(start);

        // int nums[] = {1, 2};
        // majorityElement(nums);
        // size of union code for length of union of two arrays

        // union(nums1, nums2);
        // intersection(nums1, nums2);

    }
}
