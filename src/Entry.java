public class Entry<Key extends Comparable<Key>,Value> {
    private Key key;
    private Value value;
    public Entry(Key newKey, Value newValue) {
        key = newKey;
        value = newValue;
    }

    public Key getKey(){return key;}
    public Value getValue(){return value;}
    public void setKey(Key newKey) {key = newKey;}
    public void setValue(Value newValue) {value = newValue;}

}
