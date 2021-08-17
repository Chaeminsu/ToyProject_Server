package Message;

import WorkFlow.Worker;
import WorkFlow.Working;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SocketThreadServer implements Working {

    // Field
    private final int PORT_NUMBER = 7000;
    private static final int THREAD_CNT = 5;
    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_CNT);

    public void socketThreadPoolStart()
    {
        try {
            ServerSocket server = new ServerSocket(PORT_NUMBER);
            while(true){
                System.out.println("-------���� �����------");
                Socket socket = server.accept();
                System.out.println(socket.getInetAddress() + "�� ���� �����û�� ����");
                try{
                    threadPool.execute(new SocketWrrapper(socket));
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void LogicWorking(Worker Ws) {

    }
}
