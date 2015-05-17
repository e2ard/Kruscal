
public class Edge {
	Vertice begin;
	Vertice end;
	int value;
	public Edge(Vertice begin, Vertice end, int value) {
		super();
		this.begin = begin;
		this.end = end;
		this.value = value;
	}
	public Vertice getBegin() {
		return begin;
	}
	public void setBegin(Vertice begin) {
		this.begin = begin;
	}
	public Vertice getEnd() {
		return end;
	}
	public void setEnd(Vertice end) {
		this.end = end;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}

}
