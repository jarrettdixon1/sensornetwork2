
public class NodeHeap {// max heap
	
	private Node heapArr[];
	private int maxSize;
	private int currentSize;
	int postion[];
	
	public NodeHeap(int mx){
		maxSize = mx;
		currentSize = 0;
		heapArr = new Node[maxSize];
		postion = new int[maxSize];
	}
	
	public boolean isEmpty(){
		return currentSize==0;
	}
	public boolean insert(int key){
		if(currentSize == maxSize)
			return false;
		Node newNode = new Node(key);
		heapArr[currentSize] = newNode;
		trickleUp(currentSize++);
		return true;
	}
	
	public void trickleUp(int index){
		int parent = (index-1 / 2);
		Node bottom = heapArr[index];
		
		while(index > 0 && heapArr[parent].getKey() < bottom.getKey()){
			heapArr[index] = heapArr[parent];
			index =  parent;
			parent = (parent - 1)/ 2;
		}// end while
		heapArr[index] = bottom;
	}// end trickleUp
	
	public Node remove(){
		Node root = heapArr[0];
		heapArr[0] = heapArr[--currentSize];
		trickleDown(0);
		return root;
	}// end remove
	
	public void trickleDown(int index){// might have to check to see right child exists
		int largerChild;				// check right child value against current size
		Node top = heapArr[index];
		while(index<currentSize/2){
			int leftChild = 2*index +1;
			int rightChild = leftChild + 1;
			
			if(rightChild < currentSize && heapArr[leftChild].getKey() < heapArr[rightChild].getKey() )// rightChild exists
				largerChild = rightChild;
			else
				largerChild = leftChild;
			
			if(top.getKey() >= heapArr[largerChild].getKey() )
				break;
			
			
			heapArr[index] = heapArr[largerChild];
			index = largerChild;
		}// end while
		heapArr[index] = top;
	}
	public boolean change(int index, int newValue){
		if(index< 0 || index>= currentSize)
			return false;
		int oldValue = heapArr[index].getKey();
		heapArr[index].setKey(newValue);
		
		if(oldValue < newValue)
			trickleUp(index);
		else
			trickleDown(index);
		return true;
	}
	
	
	
	
	
	
}
