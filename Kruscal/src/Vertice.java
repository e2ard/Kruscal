
public class Vertice {
	String name;
	Vertice first;
	
	public Vertice(String name){
		this.name = name;
		this.first = this;
	}
	public Vertice(String name, Vertice first) {
		super();
		this.name = name;
		this.first = this;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Vertice getFirst() {
		return first;
	}
	public void setFirst(Vertice first) {
		this.first = first;
	}
	@Override
	public String toString() {
		return name + " " + first.getName();
	}

}
