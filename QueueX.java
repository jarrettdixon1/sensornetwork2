
public class QueueX {
    
    private int size;
    private int[] arr;
    private int front;
    private int rear;
    
    public QueueX(){
	size = 20;
	arr = new int[size];
	front = 0;
	rear = -1;
    }
    public QueueX(int s){
	size = s;
	arr = new int[size];
	front = 0;
	rear = -1;
    }
    public void insert(int j){
	if(rear == size -1 )
	    rear = -1;
	arr[++rear] = j;
    }
    public int remove(){
    int temp = arr[front++];
    if(front == size)
	front = 0;
    return temp;
    }
    public boolean isEmpty(){
	return ( (rear + 1 == front) || (front + size == rear) );
    }
}
