public class BHeap<Key extends Comparable<Key>,Value> {
    private Entry[] a; // a[0]은 사용안함
    private int N; // 힙의 크기
    private BHeap(Entry[] harray, int initialSize) {
        a = harray;
        N = initialSize;
    }
    public int size(){return N;} // 힙의 크기 리턴
    private boolean greater(int i, int j) {
        return a[i].getKey().compareTo(a[j].getKey()) > 0;
    }
    private void swap(int i, int j) { // a[i]와 a[j]를 교환
        Entry temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    public void createHeap(){
        for(int i = N/2; i > 0; i--) {
            downheap(i);
        }
    }

    private void downheap(int i) { // i는 현재 노드의 인덱스
        while(2*i <= N) { // i의 왼쪽 자식노드가 힙에 있으면
            int k = 2*i; // k는 왼쪽 자식노드의 인덱스
            if (k < N && greater(k,k+1)) k++; // k가 승자의 인덱스가 됨
            if(!greater(i,k)) break; // 현재 노드가 자식 승자와 같거나 루프를 중단하고
            swap(i,k); // 현재 노드가 자식 승자보다 크면 현재 노드와 자식 승자와 교환
            i = k; // 자식 승자가 현재 노드가 되어 다시 반복하기 위해
        }
    }

    public void insert(Key newKey, Value newValue) { // 새로운 항목 삽입
        Entry temp = new Entry(newKey,newValue); // Entry 생성
        a[++N] = temp; // 새로운 키(항목)를 배열 마지막 항목 다음에 저장
        upheap(N); // 위로 오라가며 힙속성 회복시키기 위해
    }

    public void upheap(int j) { // j는 현재 노드의인덱스
        while(j > 1 && greater(j/2,j)) { // 현재 노드가 루트가 아니고 동시에 부모가 크면
            swap(j/2,j); //부모와 현재 노드 교환
            j = j/2; // 부모가 현재 노드가 되어다시 반복하기 위해해
       }
    }

    public Entry deleteMin(){
        Entry min = a[1];
        swap(1,N--);
        a[N+1] = null;
        downheap(1);
        return min;
    }

}
