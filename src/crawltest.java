import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class crawltest {
//    public static void main(String[] args) {
//        try {
//            URL url = new URL("https://fptshop.com.vn/dien-thoai/apple-iphone");
//            Scanner scn = new Scanner(new InputStreamReader(url.openStream()));
//            scn.useDelimiter("\\Z");
//            String content = scn.next();
//            scn.close();
//            content.replaceAll("\\n", "");
//            Pattern p = Pattern.compile("(\\S.*\\d)<span>đ<");
//            Matcher m = p.matcher(content);
//            while (m.find()) {
//                System.out.println(m.group(1));
//            }
//
//
//        }catch (FileNotFoundException f){
//            System.err.println("Find not found at Crawl_info");
//        }catch(MalformedURLException m){
//            m.printStackTrace();
//        }catch(IOException ioe){
//            ioe.printStackTrace();
//        }
//    }
}
