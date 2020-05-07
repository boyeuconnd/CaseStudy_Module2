package codegym.crawl_manager;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Crawl_info {
    public static final String FPT_SHOP_IPHONE = "https://fptshop.com.vn/dien-thoai/apple-iphone";
    public static final String FPT_SHOP_SAMSUNG = "https://fptshop.com.vn/dien-thoai/samsung?sort=gia-cao-den-thap";
    private Crawl_info(){};
    private static Crawl_info instance;
    public synchronized static Crawl_info getInstance(){
        if(instance==null){
            instance = new Crawl_info();
        }
        return instance;
    }
    public void Crawling(String source) {
        try {
            File productCrawl = new File("D:\\CodeGym\\MiddleTest_M2\\src\\codegym\\storage\\productFile.txt");
            BufferedWriter buffWrite = new BufferedWriter(new FileWriter(productCrawl));
            URL url = new URL(source);
            Scanner scn = new Scanner(new InputStreamReader(url.openStream()));
            scn.useDelimiter("\\Z");
            String content = scn.next();
            scn.close();
            content.replaceAll("\\n+", "");
            Pattern p = Pattern.compile("'Home','(.*)',(.*?),(.*?),0000,(.*)href=\"(.*)\" title=");
            Matcher m = p.matcher(content);
            while (m.find()) {
//                System.out.println(m.group(1) + " " + m.group(2) + " " + m.group(3)+" https://fptshop.com.vn"+m.group(5));

                buffWrite.write(m.group(2)+","+m.group(1)+","+m.group(3)+",1,https://fptshop.com.vn"+m.group(5)+"\n");
                buffWrite.flush();
            }
            buffWrite.close();

        }catch (FileNotFoundException f){
            System.err.println("Find not found at Crawl_info");
        }catch(MalformedURLException m){
            m.printStackTrace();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}
