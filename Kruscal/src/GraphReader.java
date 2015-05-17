import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class GraphReader {
	String input = "";


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
	
	//other methods
	public void readFromFile(){
		FileReader fr = getFileReader(input);
		if( fr != null){
			BufferedReader br = new BufferedReader(fr);
		    try {
		        StringBuilder sb = new StringBuilder();
		        String line = br.readLine();
		        String[] splited = line.trim().split(" ");
		        //get vertices
		        for(String s1 : splited){
		        	
		        }
		        line = br.readLine();
		        int skip = 2;
		        do  {
		        	splited = line.trim().split(" ");
		        	
		        	for (int i = skip; i < splited.length; i++){
		        		System.out.println("vertice " + splited[i]);
		        	}
		        	skip++;
		            System.out.println(line);
		            
		        } while((line = br.readLine()) != null);
		        String everything = sb.toString();
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
