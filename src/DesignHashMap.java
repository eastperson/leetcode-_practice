import java.util.HashMap;

public class DesignHashMap {
    public static void main(String[] args) {
        MyHashMap obj = new MyHashMap();
        obj.put(1,1);
        obj.put(2,2);
        System.out.println(obj.get(1));
        System.out.println(obj.get(3));
        obj.put(2,1);
        System.out.println(obj.get(2));
        obj.remove(2);
        System.out.println(obj.get(2));
    }
}


class MyHashMap {
    private int M;
    private Integer[] kArr;
    private Integer[] vArr;

    /** Initialize your data structure here. */
    public MyHashMap() {
        this.M = 10000;
        this.kArr = new Integer[M];
        this.vArr = new Integer[M];
    }
    private int hash(Integer key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int init = hash(key);
        if(kArr[init] == null){
            kArr[init] = key;
            vArr[init] = value;
        } else {
          vArr[init] = value;
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int init = hash(key);
        return kArr[init] != null ? vArr[init] : -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int init = hash(key);
        if(kArr[init] != null){
            kArr[init] = null;
            vArr[init] = null;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */