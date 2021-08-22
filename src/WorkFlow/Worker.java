package WorkFlow;


import DB.DBTEST;
import Message.SocketThreadServer;

public class Worker implements Working, Runnable{

    private SocketThreadServer socketThread = new SocketThreadServer();
    private DBTEST dbtest =new DBTEST();
    public void Start()
    {
        Thread task = new Thread(this);
        task.start();
        dbtest.startConnect();
        socketThread.socketThreadPoolStart();
    }
    public void run() {
        while(true)
        {
            try {
                Thread.sleep(50);
                LogicWorking(this);
            }catch(Exception e) {
                e.getStackTrace();
            }
        }
    }

    @Override
    public void LogicWorking(Worker Ws) {
        this.socketThread.LogicWorking(this);
    }
}
