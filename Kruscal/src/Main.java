
public class Main {

	public static void main(String[] args) {
		String input = "E:\\Users\\Edvard\\git\\Kruscal\\Kruscal\\src\\input.txt";
		GraphReader gr = new GraphReader(input);
		
		Graph g = new Graph();
		Vertice va = new Vertice("a");
		Vertice vb = new Vertice("b");
		Vertice vc = new Vertice("c");
		Vertice vd = new Vertice("d");
		Vertice ve = new Vertice("e");
		
		Edge e = new Edge(va, vb, 1);
		Edge e1 = new Edge(vb, vc, 1);
		Edge e2 = new Edge(va, vb, 1);
		
		g.addEdge(e);
		g.addEdge(e1);
		g.addEdge(e2);
		
		g.addVertice(ve);
		g.addVertice(va);
		g.addVertice(vd);
		
		System.out.println(g.toString() +  ' ');

	}

}
