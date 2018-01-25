// Name: Sarfaraz Ahmed
// ID: 1320168042
// Section: 01


package mathcham;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Scanner;

public class MathChamGameServer {

	public MathChamGameServer() {
		
	}
	
	static LinkedList<clientThread> clients = new LinkedList<>();
	

	
	public static void main(String[] args) {
		
		
		try {
			ServerSocket serverSocket =  new ServerSocket(88);
			
			System.out.println("MathCham Game Server Started" + " (Press any key to start the game after joining a player) ");
			
			
			new Thread(){
				
				//Override
				public void run(){
				
					super.run();
					
					Scanner console = new Scanner (System.in);
					
					//while(true){
					
					String consoleInput0 = console.nextLine();
					
					for(clientThread client : clients){
						client.writer.println( "MathCham Server: " + "What is 5+5? " );
						
					}
					
					String consoleInput1 = console.nextLine();
					
					for(clientThread client : clients){
						client.writer.println( "MathCham Server: " + "What is 1000/100? " );
						
					}
					
					
					String consoleInput2 = console.nextLine();
					
					for(clientThread client : clients){
						client.writer.println( "MathCham Server: " + "What is 5*2? " );
						
					}
					
					String consoleInput3 = console.nextLine();
					
					for(clientThread client : clients){
						client.writer.println( "MathCham Server: " + "What is 52-42? " );
						
					}
					
					
					String consoleInput4 = console.nextLine();
					
					for(clientThread client : clients){
						client.writer.println( "MathCham Server: " + "What is 8+2? " );
						
					}
					
				//	String result = console.nextLine();
					
					
				//	for(clientThread client : clients){
						
						//client.score();
					
				//		client.writer.println( "The MathChamp is " + client.nm );
						
				//	}
					
				 }
				 
					
				//}
				
				
			}.start();
			
			
			int a=1;
			
			
			while(true){
				
				clients.add (new clientThread (serverSocket.accept() ) );
				clients.peekLast().start();
				System.out.println("Player " + a + " Joined");
				a++;
				//new clientThread( serverSocket.accept() ).start();
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}

class clientThread extends Thread {
	
	Socket client;
	Scanner reader;
	Scanner reader1;
	PrintWriter writer;
	int scr = 0;
	int temp = 0;
	String nm = " ";
	
	public clientThread(Socket client){
		
		this.client = client;
		
		try {
			this.reader = new Scanner( client.getInputStream() );
			this.reader1 = new Scanner( client.getInputStream() );
			this.writer = new PrintWriter (client.getOutputStream(), true);
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Client has left");
			
			MathChamGameServer.clients.remove(this);
			
			
		}
		
	}
	
	
	
	public void run(){
		
		int s=0;
		super.run();
		writer.println("Welcome to MathCham Game" + "\n" + "Enter Your Name");
		String a= reader.nextLine();
		while(true){
		//System.out.println( "Client: " + reader.nextLine() );
		String b= reader1.nextLine();
		if(b.equals("10")){
			System.out.println( a  + " gives the Correct Answer.." + "\n" + "Press any key to send the next Question to the Player(s).." );
			writer.println( "Your answer is correct!" );
			
		    s= score();
		    
		    /*
		    if(temp>s){
				
				temp=temp;
			    nm = a; 
			}
			else
			{
				temp = s;
				nm = a;
			}
		    */
		   // c = res(a,s);
			
		}
		else{
			System.out.println( a + " gives the Wrong Answer" + "\n" + "Press any key to send the next Question to the Player(s).." );
			writer.println("Wrong Answer...");
		}
		writer.println( "Your Total Score is: " + s );
		
		}
	
		
		
		
	}
	public int score()
	{
		scr=scr+1;
		return scr;
	}
	
	
	/*
	public String res(String x, int y )
	{
		int temp=0;
		String nm =" ";
		
		if(temp>=y){
			
			temp=temp;
		    return nm; 
		}
		else
		{
			temp = y;
			nm = x;
			return nm;
		}
		
	}
	
*/
	
	
}