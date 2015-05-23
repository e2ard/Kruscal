import static org.junit.Assert.*;

import org.junit.Test;


public class TestGraph {

	@Test
	public void addVertice() {
		Graph g = new Graph();
		Vertice v = new Vertice("a");
		g.addVertice(v);
		String a = "name " + v.getName() + " first " + v.getFirst().getName();
		assertEquals(g.getVerticeAt(0).toString(),a);
	}
//	@Test
//	public void addEdge() {
//		Graph g = new Graph();
//		Vertice a = new Vertice("a");
//		Vertice b = new Vertice("b");
//		
//		Edge e = new Edge(a, b, 2);
//		g.addEdge(e);
//		String s = e.getBegin().toString() + ' ' + e.getEnd().toString() + ' ' + e.getValue();
//		assertEquals(g.getEdgeAt(0).toString(), s);
//	}
	@Test
	public void addVerticeDup() {
		Graph g = new Graph();
		Vertice va = new Vertice("a");
		Vertice vb = new Vertice("b");
//		Vertice vaa = new Vertice("a");
		
		g.addVertice(va);
		g.addVertice(vb);
		g.addVertice(va);
		assertEquals(g.getVerticeNum(),2);
	}
	@Test
	public void addEdgeDup() {
		Graph g = new Graph();
		Vertice va = new Vertice("a");
		Vertice vb = new Vertice("b");
		Vertice vc = new Vertice("c");
		Vertice vd = new Vertice("d");
//		Vertice ve = new Vertice("e");
		
		Edge e = new Edge(va, vb, 1);
		Edge e1 = new Edge(vb, vc, 1);
		Edge e2 = new Edge(vb, vd, 1);
		
		g.addEdge(e);
		g.addEdge(e2);
		g.addEdge(e1);
		
		assertEquals(g.getEdgeNum(), 3);
	}
	

}
