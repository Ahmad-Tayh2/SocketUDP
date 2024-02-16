import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        final String SERVEUR_IP = "127.0.0.1"; // Adresse IP du serveur
        final int PORT = 12345;

        try {
            Socket socket = new Socket(SERVEUR_IP, PORT);

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            System.out.print("Entrez le nom de la personne : ");
            String nom = in.readLine();
            System.out.print("Entrez l'âge de la personne : ");
            int age = Integer.parseInt(in.readLine());


            out.println(nom);
            out.println(age);


            BufferedReader serverResponse = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            int identifiantClient = Integer.parseInt(serverResponse.readLine());
            System.out.println("Identifiant du client : " + identifiantClient);


            in.close();
            out.close();
            serverResponse.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
