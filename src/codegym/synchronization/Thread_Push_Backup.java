package codegym.synchronization;


public class Thread_Push_Backup extends Synchronize implements Runnable{
    @Override
    public void run(){
        sync_Push_Thread(listManager.getBack_up());

    }


}
