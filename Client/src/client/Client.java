// Name: Sarfaraz Ahmed



package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

//import server.clientThread;

public class Client {

	public Client() {
		// TODO Auto-generated constructor stub
	}

	
	public static void main(String[] args) {
		
		
		try {
			Socket server = new Socket("localhost", 88);
			
			final Scanner reader = new Scanner( server.getInputStream() );
			PrintWriter writer = new PrintWriter ( server.getOutputStream(), true);
			
			Scanner console = new Scanner(System.in);
			
			System.out.println(reader.nextLine() );
			
	        new Thread(){
				
				//Override
				public void run(){
				
					super.run();
					while(true)
						System.out.println( reader.nextLine() );
				
					
				  }
					
		
				
			}.start();
			
			while(true){
			
			//System.out.print("Answer: " );
			
			writer.println(console.nextLine() );
			
			
			
			
		  }
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		

	}

}
