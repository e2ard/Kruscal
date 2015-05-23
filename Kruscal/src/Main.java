import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
//		String input = "E:\\Users\\Edvard\\git\\Kruscal\\Kruscal\\src\\input.txt";
//		GraphReader gr = new GraphReader(input);
//		System.out.println(gr.getGraph().toString());
//		Graph g1 = gr.getGraph();
//		
//		System.out.println(g1.getMinSpin().toString());
//		
		//generate graph
//		int num = 800;
		System.out.println("Enter number of vertices");
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		
		Graph g = new Graph();
		for(int i = 0; i < num; i++){
        	g.addVertice(new Vertice("" + i));
        }
		System.out.println("Vertices -- created");
        int skip = 2;
        float min = 0.000f;
        float max = 1.000f;
        for (int j = 0; j < num; j++){
			for (int i = skip; i < num; i++){
				Random rand = new Random();
				float length = rand.nextFloat() ;
				
				Vertice v1 = g.getVerticeAt(skip-2);
				Vertice v2 = g.getVerticeAt(i-1);
				g.addEdge(new Edge(v1, v2, length));
		//    			System.out.println(length);
				
			}
			skip++;
			if(j % 100 == 0){
				System.out.println("Loop number" + skip);
			}
        }
    	
		System.out.println(g.getWeight() + ' ' + g.getMinSpin().getWeight());
        
    
	}
	
		
	

}
