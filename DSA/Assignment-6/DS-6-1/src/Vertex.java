import java.util.*;

public class Vertex 
{
	
	private int vertexName;
	private ArrayList<Edge> adjacentEdges = new ArrayList<Edge>();
	
	Vertex(int name)
	{
		vertexName = name;
	}
	
	public void addEdge(Edge edge)
	{
		adjacentEdges.add(edge);
	}


	public int getVertexName() {
		return vertexName;
	}
	
	public ArrayList<Edge> getAdjacentEdges() {
		return adjacentEdges;
	}
	
}
