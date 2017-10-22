
public class Vertex {
	int INFINITY = Integer.MAX_VALUE;
    String label;
    boolean isInTree;
    boolean wasVisited;
    int x;
    int y;
    int key;
    int parent;
    int cost;

    public Vertex(String lab){
	label = lab;
	wasVisited = false;
	isInTree = false;
	x = 0;
	y = 0;
	key = -1;
	parent = -1;
	cost = INFINITY;
    }
    public Vertex(String lab, int posx, int posy){
	label = lab;
	wasVisited = false;
	isInTree = false;
	x = posx;
	y = posy;
	key = -1;
	parent = -1;
	cost = INFINITY;
    }
    public Vertex(String lab, int posx, int posy, int value){
    	label = lab;
    	wasVisited = false;
    	isInTree = false;
    	x = posx;
    	y = posy;
    	key = value;
    	parent = -1;
    	cost = INFINITY;
    }
    public int getx(){return x;}
    
    public int gety(){return y;}
    
    public String getName(){return label;}
    
    public void setName(String s){label = s;}
    
    public void setKey(int value){key = value;}
    
    public int getKey(){return key; }
    
    public int getParent(){return parent;}
    
    public void setParent(int p){ parent = p;}
    
    public int getCost(){ return cost;}
    
    public void setCost(int c){ cost = c;}
    


}
