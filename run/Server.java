package run;


import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends RSA{
    private ServerSocket server;
    private DataInputStream in;
    public static final int PORT = 8009;
    public static final String STOP_STRING = "##";
    public static String userMessage;


    public Server(){
        try{
            server = new ServerSocket(PORT);
            iniConnections();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void iniConnections() throws IOException {
        Socket clientSocket = server.accept();
        System.out.println("Connected to "+clientSocket.getRemoteSocketAddress());
        in = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));

        readMessages();
        
        close();
    }

    private void close() throws IOException {
        in.close();
        server.close();
    }

    private void readMessages() throws IOException {
        String line = "";
        while(!line.equals(STOP_STRING)){
            line = in.readUTF();
            userMessage = line;
            //System.out.println(line);
            //System.out.println(userMessage);
            if (userMessage.equalsIgnoreCase("test")) {
                test();
            }
            else {
                init();
                run(userMessage);
                //createCipher();
                str("Your encoded message is :");
                for (int i = 0; i < intMessage.size(); i++) {
                    System.err.print(""+intMessage.get(i));
                }
                str("");
                reset();  
            }
            
        }
        

    }

    public static void main(String[] args) {
        new Server();
        
    }
}
