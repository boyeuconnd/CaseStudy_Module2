package codegym.crawl_manager;

import codegym.model.Product;
import codegym.storage.ProductList;

import java.io.*;
import java.net.MalformedURLException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Crawl_Phone implements I_Crawl {
    public Crawl_Phone(){};
    ProductList productList = ProductList.getInstance();

    private File productCrawl = productList.getProductFile();

    protected static Queue<String> matcherString = new LinkedList<>();
    @Override
    public synchronized void crawl_Product(String source, String regex) {
        try {
            String content = GetContent.urlGetContent(source);
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(content);
            while (matcher.find()){
                if(matcher.group(3).equals("0")){
                    continue;
                }else {
                    matcherString.add(matcher.group(2)+","+matcher.group(1)+","+matcher.group(3)+",1,https://fptshop.com.vn"+matcher.group(5));
                }
            }

        }catch (FileNotFoundException f){
            System.err.println("Find not found at Crawl_Phone");
        }catch(MalformedURLException m){
            m.printStackTrace();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
    public void startThread(){
        Thread iphone = new Iphone().threadIphone;
        Thread samsung = new Samsung().threadSamsung;
        Thread xiaomi = new Xiaomi().threadXiaomi;
        Thread oppo = new Oppo().threadOppo;
//        final boolean isAllThreadsDead = samsung.getState() == Thread.State.TERMINATED
//                && iphone.getState() == Thread.State.TERMINATED
//                && xiaomi.getState() == Thread.State.TERMINATED
//                && oppo.getState() == Thread.State.TERMINATED;
        try {
            iphone.start();
            iphone.join();
            samsung.start();
            samsung.join();
            xiaomi.start();
            xiaomi.join();
            oppo.start();
            oppo.join();
            ExportToFile(productCrawl,matcherString);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    private void ExportToFile(File source,Queue<String> queue){
        try{
            BufferedWriter buffWrite = new BufferedWriter(new FileWriter(source));
            while  (!queue.isEmpty()) {
                String line = queue.poll();
                buffWrite.write(line+"\n");
                buffWrite.flush();
            }
            buffWrite.close();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }


    }
}
