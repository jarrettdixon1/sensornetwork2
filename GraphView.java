import javax.swing.JPanel;



import java.awt.Graphics;
import java.util.ArrayList;

public class GraphView extends JPanel{
	public Graph graph;


	public GraphView(Graph graph){
		this.graph = graph;
	}
	protected void paintComponent(Graphics g){
		super.paintComponent(g);

		// Scale vertices and edges to fit screen
		//  x' = x/width
		// y' = y/width

		// Draw vertices
		Vertex[] vertices = graph.getVertices();
		ArrayList<Integer> spath = graph.getsPath();
		
		
		for(int i = 0; i< vertices.length; i++)	{
			int x = vertices[i].getx();
			double xprime = (double)x*700/(double)graph.cols;
			int y = vertices[i].gety();
			double yprime = (double)y*700/(double)graph.rows;
			String name = vertices[i].label;

			//g.fillOval(x-8, y-8, 16, 16);
			// shift edges and vertices by 50 down and to the right
			g.fillOval((int)xprime-8+50, (int)yprime-8+50, 16, 16);
			//g.drawString(name, x-12, y-12);
			g.drawString(name, (int)xprime-12+50, (int)yprime-12+50);

		}
		// Draw edges  
//		for(int i = 0; i<graph.getSize(); i++){
//			ArrayList<Integer> neighbors = graph.getNeighbors(i);
//			int x1 = graph.getVertex(i).getx();
//			double x1prime = x1*700/graph.cols;
//			int y1 = graph.getVertex(i).gety();
//			double y1prime = y1*700/graph.rows;
//
//			for(int v : neighbors){
//				int x2 = graph.getVertex(v).getx();
//				double x2prime = x2*700/graph.cols;
//				int y2 = graph.getVertex(v).gety();
//				double y2prime = y2*700/graph.rows;
//				// shift edges by 50 pixels to keep in frame
//				g.drawLine((int)x1prime+50, (int)y1prime+50, (int)x2prime+50, (int)y2prime+50);
//
//
//			}
//		}
//		// Draw edges in path
		for(int i =0; i<spath.size()-1; i++ ){
			
			int x = vertices[spath.get(i)].getx();
			double xprime = (double)x*700/(double)graph.cols;
			
			int y = vertices[spath.get(i)].gety();
			double yprime = (double)y*700/(double)graph.rows;
			
		
			
			int x1 = vertices[spath.get(i+1)].getx();
			double x1prime = (double)x1*700/(double)graph.cols;
			
			int y1 = vertices[spath.get(i+1)].gety();
			double y1prime = (double)y1*700/(double)graph.rows;
			
			
			
			g.drawLine((int)xprime+50, (int)yprime+50, (int)x1prime+50, (int)y1prime+50);
			
			
			
		}


	}
}
