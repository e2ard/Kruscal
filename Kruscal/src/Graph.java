import java.util.ArrayList;


public class Graph {
	ArrayList<Edge> edges;
	ArrayList<Vertice> vertices;
	
	public Graph(ArrayList<Edge> edges, ArrayList<Vertice> vertices) {
		super();
		this.edges = new ArrayList();
		this.vertices = new ArrayList();
	}
	public Graph(){
		this.edges = new ArrayList();
		this.vertices = new ArrayList();
	}
	
	public void addVertice(Vertice v){
		for(Vertice temp : this.vertices){
			if(temp.getName().equals(v.getName())){
				return;
			}
		}
		this.vertices.add(v);
	}
	public Vertice getVerticeAt(int i){
		if(i < this.vertices.size()){
			return this.vertices.get(i);
		}
		return null;
		
	}
	public void addEdge(Edge e){
		for(Edge temp : this.edges){
			
			if(temp.toString().equals(e.toString()) || (temp.toStringReverse().equals(e.toStringReverse()))||
			   temp.toString().equals(e.toStringReverse()) || (temp.toStringReverse().equals(e.toString()))){
				return;
			}
		}
		this.edges.add(e);
		this.addVertice(e.getBegin());
		this.addVertice(e.getEnd());
	}
	public Edge getEdgeAt(int i){
		if(i < this.edges.size()){
			return this.edges.get(i);
		}
		return null;
	}
	public int getVerticeNum(){
		return this.vertices.size();
	}
	public int getEdgeNum(){
		return this.edges.size();
	}
	public String toString(){
		String vert = "";
		for(Vertice v : this.vertices){
			vert += v.getName() + ' ';
		}
		String edge = "";
		for(Edge e : this.edges){
			edge += e.getBegin().getName() + e.getEnd().getName() + ' ';
		}
		return "vertices: " + vert + '\n' + "edges: " + edge;
	}
}
