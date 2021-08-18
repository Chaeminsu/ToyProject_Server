package Main;

import WorkFlow.Worker;

public class StartServer {

    private Worker _work = new Worker();

    public void start()
    {
        _work.Start();
    }
}
