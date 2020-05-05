package codegym.synchronization;

import codegym.model.Product;
import codegym.storage.ProductList;

import java.io.*;

public class Synchronizer extends ProductList {
    public void syncPull(){
        String line;
        String[] split;
        try{
            BufferedReader buffRead = new BufferedReader(new FileReader(productFile));
            while ((line=buffRead.readLine())!=null){
                split = line.split(",");
                Product addProduct = new Product(split[0],split[1],Integer.parseInt(split[2]),Integer.parseInt(split[3]),split[4]) {};
                productsList.add(addProduct);
            }
            buffRead.close();
        }catch (FileNotFoundException e){
            System.err.println("File not found_at method pull");

        }catch (IOException r){
            r.printStackTrace();
        }

    }
    public void syncPush(){
        try{
            BufferedWriter buffWrite = new BufferedWriter(new FileWriter(productFile));
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
