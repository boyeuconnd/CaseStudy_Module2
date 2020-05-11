package codegym.synchronization;

import codegym.model.Product;
import codegym.storage.ProductList;

import java.io.*;
import java.util.ArrayList;

public class Synchronize{
    ProductList listManager = ProductList.getInstance();
    ArrayList<Product> productsList = listManager.getArrayList();
    public void syncPull(File syncFile){
        String line;
        String[] split;
        try{
            BufferedReader buffRead = new BufferedReader(new FileReader(syncFile));
            while ((line=buffRead.readLine())!=null){
                split = line.split(",");
                Product addProduct = new Product(split[0],split[1],Integer.parseInt(split[2]),Integer.parseInt(split[3]),split[4]) {};
                productsList.add(addProduct);
            }
            buffRead.close();
        }catch (FileNotFoundException e){
            System.err.println("Repo not found, starting sync from back_up repo");
            syncPull(listManager.getBack_up());

        }catch (IOException r){
            r.printStackTrace();
        }

    }
    public void syncPush() {
        try{
            Runnable syncBackup = new Thread_Push_Backup();
            Runnable syncRepo = new Thread_Push_Repo();
            Thread threadPushBackup = new Thread(syncBackup);
            Thread threadPushRepo = new Thread(syncRepo);
            threadPushBackup.start();
            threadPushRepo.start();
            threadPushRepo.join();
            threadPushBackup.join();

        }catch (InterruptedException ie){
            ie.printStackTrace();
        }

    }
    protected void sync_Push(File source) {
        try{
            BufferedWriter buffWrite = new BufferedWriter(new FileWriter(source));
            for (Product element:productsList ) {
                buffWrite.write(element.getId()+","
                        +element.getName()+","
                        +element.getPrice()+","
                        +element.getStatus()+","
                        +element.getDescription()+"\n");
            }
            buffWrite.flush();
        }catch (FileNotFoundException e){
            System.err.println("File not found_at method push");
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
