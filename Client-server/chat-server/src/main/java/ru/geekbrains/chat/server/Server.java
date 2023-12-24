package main.java.ru.geekbrains.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private final ServerSocket serverSocket;

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    /**
     * Метод runServer запускает бесконечный цикл мониторинга новых подключений в рамках основного потока приложения.
     * При вызове метода accept создается объект клиентского менеджера и в рамках нового потока вызываются инструкции
     * в контексте метода run. Затем цикл повторяется, начиная с прослушивания основного потока.
     * В случае появления исключений, вызывается метод закрытия серверного сокета.
     */
    public void runServer() {
        try {
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                ClientManager clientManager = new ClientManager(socket);
                System.out.println("Подключен новый клиент!");
                Thread thread = new Thread(clientManager);
                thread.start();
            }
        } catch (IOException e) {
            closeSocket();
        }
    }

    private void closeSocket() {
        try {
            if (serverSocket != null) serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}