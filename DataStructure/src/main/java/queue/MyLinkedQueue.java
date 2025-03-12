package queue;

public class MyLinkedQueue<T> implements IQueue<T> {

    private Node head;
    public Node tail;
    private int size;

    public MyLinkedQueue() {
        this.size = 0;
        this.head = new Node(null); // dummy node
        this.tail = this.head;
    }

    @Override
    public void offer(T data) { // queue에 데이터를 넣는 연산
        Node node = new Node(data);
        this.tail.next = node;
        this.tail = this.tail.next;
        this.size++;
    }

    @Override
    public T poll() { // queue에서 데이터를 빼오는 연산
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }
        Node node = this.head.next;
        this.head.next = node.next;
        node.next = null;
        this.size--;

        if (this.head.next == null) {
            this.tail = this.head;
        }

        return node.data;
    }

    @Override
    public T peek() {  // queue에서 데이터를 빼지는 않고 그대로 둔 상태에서 가장 앞에 데이터가 무엇인지 확인하는 연산
        if (this.isEmpty()) {
            throw  new IllegalStateException();
        }
        return this.head.next.data;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        this.head.next = null;
        this.tail = head;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.head.next == null;
    }

    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }

        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
