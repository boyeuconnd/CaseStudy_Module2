package codegym.crawl_manager;

import java.io.*;
import java.net.MalformedURLException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Crawl_Phone implements I_Crawl {
    public Crawl_Phone(){};
//    public synchronized static Crawl_Phone getInstance(){
//        if(instance==null){
//            instance = new Crawl_Phone();
//        }
//        return instance;
//    }
//    private static Crawl_Phone instance;
    private File productCrawl = new File("D:\\CodeGym\\MiddleTest_M2\\src\\codegym\\storage\\Crawl.txt");
    public static Queue<String> matcherString = new LinkedList<>();
    @Override
    public synchronized void crawl_Product(String source,String regex) {
        try {
            String content = GetContent.urlGetContent(source);
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(content);
            while (matcher.find()){
                matcherString.add(matcher.group(2)+","+matcher.group(1)+","+matcher.group(3)+",1,https://fptshop.com.vn"+matcher.group(5));
            }

//            ExportToFile(productCrawl, matcherQueue);

        }catch (FileNotFoundException f){
            System.err.println("Find not found at Crawl_Phone");
        }catch(MalformedURLException m){
            m.printStackTrace();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
    public void startThread(){
        try{
            Iphone iphone = new Iphone();
            Samsung samsung = new Samsung();
            iphone.threadIphone.start();
            iphone.threadIphone.join();
            samsung.threadSamsung.start();
            samsung.threadSamsung.join();
            ExportToFile(productCrawl,matcherString);
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
    }

    public synchronized void ExportToFile(File source,Queue<String> queue){
        try{
            BufferedWriter buffWrite = new BufferedWriter(new FileWriter(source));
            while  (!queue.isEmpty()) {
                String line = queue.poll();
                buffWrite.write(line+"\n");
                buffWrite.flush();
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }

//        buffWrite.close();
    }
}
