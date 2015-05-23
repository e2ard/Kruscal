import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


public class Graph {
	PriorityQueue<Edge> edges;
	ArrayList<Vertice> vertices;
	EdgeComparator comparator;
	float weight;
	
	public Graph(PriorityQueue<Edge> edges, ArrayList<Vertice> vertices) {
		super();
		this.vertices = new ArrayList<Vertice>();
		comparator = new EdgeComparator();
		Comparator<Edge> comparator = new LengthComparator();
		this.edges = new PriorityQueue<Edge>(10, comparator);
	}
	public Graph(){
		this.vertices = new ArrayList<Vertice>();
		comparator = new EdgeComparator();
		Comparator<Edge> comparator = new LengthComparator();
		this.edges = new PriorityQueue<Edge>(10, comparator);
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
		Edge[] edgeTemp = this.getEdges();
		for(int i = 0; i < edgeTemp.length; i++){
			if(comparator.compare(edgeTemp[i], e) > 0){
				return;
			}
		}
		this.edges.offer(e);
		this.weight += e.getValue();
		this.addVertice(e.getBegin());
		this.addVertice(e.getEnd());
	}
	public Edge getMinEdge(){
		if(this.edges.size() > 0){
			return this.edges.remove();
		}
		return null;
	}
	public float getWeight(){
		return this.weight;
	}
	public int getVerticeNum(){
		return this.vertices.size();
	}
	public int getEdgeNum(){
		return this.edges.size();
	}
	public Edge[] getEdges(){
		Edge[] edgeTemp = new Edge[edges.size()];
		edges.toArray(edgeTemp);
		return edgeTemp;
	}
	public String toString(){
		String vert = "";
		for(Vertice v : this.vertices){
			vert += v.getName() + ' ';
		}
		String edge = "";
		Edge[] temp = new Edge[edges.size()];
				this.edges.toArray(temp);
		for(Edge e : temp){
			edge += e.getBegin().getName() + e.getEnd().getName() + "v:" + e.getValue()  + ' ' ;
			if(edge.length() % 20 == 0){
				edge += '\n';
			}
		}
		return "vertices: " + vert + '\n' + "edges: " + edge + "\n" + weight;
	}
	public Graph getMinSpin(){
		Graph minSpin = new Graph();
		Edge temp = this.getMinEdge();
		while(temp != null){
			if(temp.getBegin().getFirst() != temp.getEnd().getFirst()){
				temp.getEnd().setFirst(temp.getBegin().getFirst());
				minSpin.addEdge(temp);
			}
			temp = this.getMinEdge();
		}
		return minSpin;
	}
}
