// package Hashmap;

// import java.util.HashMap;
// import java.util.Map;
// import java.util.Set;

// public class hashMap {

//     public static void main(String[] args) {
//         HashMap<String, Integer> map = new HashMap<>();
//         // key value pairs
//         map.put("A", 1);
//         map.put("B", 2);
//         map.put("C", 3);
//         map.put("A", 0); // overwrites the value of A
//         if (
//             map.containsKey("A")) {
//                 System.out.println("hai");
            
//         }
//         // System.out.println(map);
//         // System.out.println(map.get("A"));
//         // System.out.println(map.get("B")); // key's value print karte hai matlab search
          
//         // int arr[] = {12, 15, 18};
//         // for (int i = 0; i < arr.length; i++) {
//         //     System.out.println(arr[i] + " ");
//         // }
//         // System.out.println();

//         // for (int i : arr) {
//         //     System.out.println(i + " ");
//         // }
//         // System.out.println();

//         // Ist way
//         // for(Map.Entry<String, Integer> e :map.entrySet()) {
//         //     System.out.println(e.getKey() + " " + e.getValue());
//         // }


//         // IInd way
//         Set<String> Keys = map.keySet();
//         for (String key : Keys) {
//             // System.out.println(key + " " + map.get(key));
//         }
//         map.remove("A");
//         System.out.println(map);
//     }
// }
