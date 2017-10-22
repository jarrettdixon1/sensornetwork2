import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.plaf.synth.SynthSeparatorUI;

/*
 * generate nodes at random
 * get transmission range
 * determine whether graph is connected
 * if not connected state which components are connected
 *
 *
 * ask user for width x and length y
 *
 * ask for transmission range
 * ** watch out for int division,  use floats or real numbers
 *
 * determine if nodes are connected individually
 *
 * determine if nodes are connected as a whole e.g. if the graph is connected (use bfs)
 *
 *
 * create adjacency list of graph and ask if it is connected using bfs or dfs
 *
 * extra credit, visualize graph network
 */
public class SensorNetworkTwo  extends JFrame{
	static Random rnd = new Random();
	static int vertexCount = 0;
	static Graph g;

	public static void main(String []args){
		Scanner input = new Scanner(System.in);

		boolean repeat = true;



		do{

			System.out.println("Enter width: ");
			int width = input.nextInt();
			System.out.println("Enter height: ");
			int height = input.nextInt();
			System.out.println("Enter number of nodes: ");
			int nVerts = input.nextInt();
			System.out.println("Enter transmission range: ");
			int range = input.nextInt();
			System.out.println("Enter the number of Data Generating Nodes");
			int p = input.nextInt();// p stands for number of data generating Nodes
			System.out.println("Enter the number of data packets each Data Generating Node has");
			int q = input.nextInt();
			System.out.println("Enter the number of data packets each Storage Node can store");
			int m = input.nextInt();
			int DG = 0;
			int SN = 0;


			if( (p*q ) <= ((nVerts-p)*m)){

				repeat = false;


				g = new Graph(width,height,nVerts);


				for(int i = 0; i<nVerts; i++){
					String name = "" + i;
					g.addVertex(name, rnd.nextInt(width), rnd.nextInt(height));
				}
				for(int i = 0; i<g.vertexList.length; i++){
					for(int j = 0; j< g.vertexList.length; j++){
						if(i!=j && isConnected(g.vertexList[i],g.vertexList[j], range) ){
							//g.addEdge(i, j);
							int distance = (int)getDistance(g.vertexList[i],g.vertexList[j]);
							g.addEdge(i,j,distance);
						}
					}
				}
				System.out.println("Transmission range: "+ range);

				boolean isConnected = g.DFSALL();
				/*
				 * randomly pick p DG nodes
				 * ask user to pick a DG node and SN
				 */
				ArrayList<Integer> DGs = new ArrayList<Integer>();
				ArrayList<Integer> SNs = new ArrayList<Integer>();
				for(int i = 0; i<nVerts; i++){
					SNs.add(i);
				}
				for (int i = 0; i < p; i++) {
					int temp = SNs.remove( rnd.nextInt(SNs.size()));
					DGs.add(temp);

				}
//				System.out.print("DG's : ");
//				for(int i = 0; i<DGs.size();i++){
//					System.out.print(DGs.get(i)  + " ");
//				}
//				System.out.println();
//				System.out.print("SN's : ");
//				for(int i = 0; i<SNs.size(); i++){
//					System.out.print(SNs.get(i) + " "	);
//				}

				System.out.println();
				if(isConnected){

					System.out.print("DG's : ");
					for(int i = 0; i<DGs.size();i++){
						System.out.print(DGs.get(i)  + " ");
					}
					System.out.println();
					System.out.println("Enter Data Generating Node");
					int source = input.nextInt();


					g.path(source);
				}



				if(isConnected){


					//g.printAdjList();
					//g.printVertexList();

					
					System.out.print("SN's : ");
					for(int i = 0; i<SNs.size(); i++){
						System.out.print(SNs.get(i) + " "	);
					}
					System.out.println();
					System.out.println("Enter Storage Node");
					int end = input.nextInt();
					ArrayList<Integer> list = new ArrayList<Integer>();
					
					g.printPath(g.sPath, end,list);
					
					g.spath = list;
					
					JFrame frame = new SensorNetworkTwo();
					frame.setTitle("Sensor Network Two");
					frame.setSize(800,800);
					frame.setLocationRelativeTo(null);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
					
					


				}else{
					repeat = true;
					System.out.println("the network is not connected, please enter a different set of input");
					input.nextLine();
				}
			}else{
				repeat = true;
				System.out.println("there is not enough storage in the network, please enter a different set of input");
				input.nextLine();
			}

		}while(repeat);


	}


	public SensorNetworkTwo(){
		add(new GraphView(g));
	}



	public static Vertex generateNode(int width, int height){
		String s = "" + vertexCount++;
		int x = rnd.nextInt(width);
		int y = rnd.nextInt(height);
		Vertex v = new Vertex(s,x,y);
		return v;
	}
	public static boolean isConnected(Vertex v, Vertex w,int range){// compares euclidean distance against range
		int dx = v.getx() - w.getx();
		int dy = v.gety() - w.gety();
		double distance = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy,2));

		return (range >= distance);
	}
	public static double getDistance(Vertex v, Vertex w){// e
		int dx = v.getx() - w.getx();
		int dy = v.gety() - w.gety();
		double distance = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy,2));

		return distance;
	}

}
