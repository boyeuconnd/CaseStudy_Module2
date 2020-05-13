package codegym.crawl_manager;

public interface I_Crawl {
    String FPT_SHOP_IPHONE = "https://fptshop.com.vn/dien-thoai/apple-iphone";
    String FPT_SHOP_SAMSUNG = "https://fptshop.com.vn/dien-thoai/samsung?sort=gia-cao-den-thap";
    String IPHONE_REGEX = "'Home','(.*)',(.*?),(.*?),0000,(.*)href=\"(.*)\" title=";
    String SAMSUNG_REGEX = "'Home','(S.*)',(.*?),(.*?),0000,(.*)href=\"(.*)\" title=";
    void crawl_Product(String link,String regex);
}
