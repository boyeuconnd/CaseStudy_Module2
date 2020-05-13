package codegym.crawl_manager;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class GetContent {
    public static String urlGetContent(String link) throws IOException {
        URL url = new URL(link);
        Scanner scn = new Scanner(new InputStreamReader(url.openStream()));
        scn.useDelimiter("\\Z");
        String content = scn.next();
        scn.close();
        content.replaceAll("\\n+", "");
        return content;

    }
}
