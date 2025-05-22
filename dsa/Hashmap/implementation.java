// package Hashmap;

// import java.util.ArrayList;
// import java.util.LinkedList;

// public class implementation {
//     static class HashMap<K, V> {
//         private class Node {
//             K key;
//             V value;

//             public Node(K key, V value) {
//                 this.key = key; 
//                 this.value = value;
//             }
//         }

//         private int n; // n = nodes
//         private int N; // N = buckets
//         private LinkedList<Node> buckets[]; // N = buckets.length

//         @SuppressWarnings("unchecked")
//         public HashMap() {
//             this.N = 4;
//             this.buckets = new LinkedList[4];
//             for (int i = 0; i < 4; i++) {
//                 this.buckets[i] = new LinkedList<>();
//             }
//         }

//         private int hashFunction(K key) {
//             int hc = key.hashCode();
//             return Math.abs(hc) % N;
//         }

//         private int searchInLL(int bi, K key) {
//             LinkedList<Node> ll = buckets[bi];
//             for (int i = 0; i < ll.size(); i++) {
//                 Node node = ll.get(i);
//                 if (node.key.equals(key)) {
//                     return i;
//                 }
//             }
//             return -1;
//         }

//         private void rehash() {
//             LinkedList<Node> oldBuckets[] = buckets;
//             buckets = new LinkedList[2 * N];
//             for (int i = 0; i < 2 * N; i++) {
//                 buckets[i] = new LinkedList<>();
//             }
//             n = 0;
//             for (int i = 0; i < oldBuckets.length; i++) {
//                 LinkedList<Node> ll = oldBuckets[i];
//                 for (int j = 0; j < ll.size(); j++) {
//                     Node node = ll.get(j);
//                     put(node.key, node.value);
//             }
//             }
//         }

//         public void put(K key, V value) {
//             int bi = hashFunction(key);
//             int di = searchInLL(bi, key);
//             if (di == -1) {
//                 LinkedList<Node> ll = buckets[bi];
//                 Node nn = new Node(key, value);
//                 ll.addLast(nn);
//                 n++;
//                 double lambda = (1.0 * n) / N;
//                 if (lambda > 2.0) {
//                     rehash();
//                 }
//             } else {
//                 LinkedList<Node> ll = buckets[bi];
//                 Node nn = ll.get(di);
//                 nn.value = value;
//             }
//         }

//         public boolean containsKey(K key) {
//             int bi = hashFunction(key);
//             int di = searchInLL(bi, key);
//             if (di == -1) {
//                 return false;
//             }
//             return true;
//         }

//         public V remove(K key) {
//             int bi = hashFunction(key);
//             int di = searchInLL(bi, key);
//             if (di == -1) {
//                 return null;
//             }
//             LinkedList<Node> ll = buckets[bi];
//             Node node = ll.remove(di);
//             n--;
//             return node.value;
//         }

//         public V get(K key) {
//             int bi = hashFunction(key);
//             int di = searchInLL(bi, key);
//             if (di == -1) {
//                 return null;
//             }
//             LinkedList<Node> ll = buckets[bi];
//             Node node = ll.get(di);
//             return node.value;
//         }

//         public ArrayList<K> keySet() {
//             ArrayList<K> keys = new ArrayList<>();
//             for (int i = 0; i < buckets.length; i++) {
//                 LinkedList<Node> ll = buckets[i];
//                 for (int j = 0; j < ll.size(); j++) {
//                     Node node = ll.get(j);
//                     keys.add(node.key);
//                 }
//             }
//             return keys;
//         }

//         public boolean isEmpty() {
//             return n == 0;
//         }
//     }

//     public static void main(String[] args) {
//         HashMap<String, Integer> map = new HashMap<>();
//         map.put("India", 190);
//         map.put("China", 200);
//         map.put("US", 50);

//         // if (map.containsKey("India")) {
//         //     System.out.println("India is present");
//         // }

//         ArrayList<String> keys = map.keySet();
//         for (int index = 0; index < keys.size(); index++) {
//             System.out.println(keys.get(index)+" " + map.get(keys.get(index)));
//         }
//         map.remove("India");
//         System.out.println(map.get("India"));
//     }
// }
