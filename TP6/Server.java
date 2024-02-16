import java.io.*;
import java.net.*;

public class Serveur {
    public static void main(String[] args) {
        final int PORT = 12345;

        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Serveur démarré sur le port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Nouvelle connexion : " + clientSocket);

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String nom = in.readLine();
                int age = Integer.parseInt(in.readLine());

                int identifiantClient = clientSocket.hashCode();

                out.println(identifiantClient);

                System.out.println("Informations reçues du client " + identifiantClient + " : " + nom + ", " + age);

                // Fermer les flux et la connexion avec le client
                in.close();
                out.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
