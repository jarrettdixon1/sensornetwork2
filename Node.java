
public class Node {
	int iData;
	int parent;
	int cost;
	int INFINITY = Integer.MAX_VALUE;
	
	public Node(int key){
		iData  = key;
		parent = -1;
		cost = INFINITY;
	}
	public int getKey(){
		return iData;
	}
	public void setKey(int id){
		iData = id;
	}
	public int getParent(){
		return parent;
	}
	public void setParent(int par){
		parent = par;
	}
	public int getCost(){
		return cost;
	}
	public void setCost(int c){
		cost = c;
	}

}
