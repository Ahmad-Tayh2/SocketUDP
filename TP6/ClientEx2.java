import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        final String SERVEUR_IP = "127.0.0.1"; 
        final int PORT = 12345;

        try {
            Socket socket = new Socket(SERVEUR_IP, PORT);

            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            Voiture voiture = new Voiture("Berline", "Toyota");
            out.writeObject(voiture);

            Voiture voitureModifiee = (Voiture) in.readObject();
            System.out.println("Quantité de carburant après modification par le serveur : " + voitureModifiee.getCarburant());

            in.close();
            out.close();
            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
