import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class GraphReader {
	String input = "";
	Graph g;

	public GraphReader(String input) {
		super();
		this.input = input;
		readFromFile();
	}
	
	public String getIntput() {
		return input;
	}

	public void setIntputPath(String intput) {
		this.input = intput;
	}
	public Graph getGraph(){
		return this.g;
	}
	//other methods
	public void readFromFile(){
		FileReader fr = getFileReader(input);
		g = new Graph();
		if( fr != null){
			BufferedReader br = new BufferedReader(fr);
		    try {
		        StringBuilder sb = new StringBuilder();
		        String line = br.readLine();
		        String[] splited = line.trim().split(" ");
		        //get vertices
		        ArrayList<Vertice> vert = new ArrayList<Vertice>();
		        for(String s1 : splited){
		        	g.addVertice(new Vertice(s1));
		        }
		        line = br.readLine();
		        int skip = 2;
		        do {
		        	splited = line.trim().split(" ");
		        	
		        	for (int i = skip; i < splited.length; i++){
		        		int length = Integer.parseInt(splited[i]);
		        		if( length!= 0){
		        			Vertice v1 = g.getVerticeAt(skip-2);
		        			Vertice v2 = g.getVerticeAt(i-1);
		        			g.addEdge(new Edge(v1,v2, length));
		        		}
		        	}
		        	skip++;
//		            System.out.println(line);
		        } while((line = br.readLine()) != null);
		        br.close();
		    }catch(IOException e){
		    	
		    }
		}
	}
	private FileReader getFileReader(String input){
		File f = new File(input);
		if(f.exists() && !f.isDirectory()) {
			System.out.println("File Found"); 
			try {
				return new FileReader(input);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("File not found");
		}
		return null;
	}
	

}
