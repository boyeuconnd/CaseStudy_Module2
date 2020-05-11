package codegym.synchronization;


public class Thread_Push_Repo extends Synchronize implements Runnable {
    @Override
    public void run() {
        sync_Push(listManager.getProductFile());

    }


}
