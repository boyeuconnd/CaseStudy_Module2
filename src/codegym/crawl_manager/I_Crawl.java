package codegym.crawl_manager;

public interface I_Crawl {
    String FPT_IPHONE = "https://fptshop.com.vn/dien-thoai/apple-iphone";
    String FPT_SAMSUNG_1 = "https://fptshop.com.vn/dien-thoai/samsung?sort=gia-cao-den-thap";
    String FPT_SAMSUNG_2 = "https://fptshop.com.vn/dien-thoai/samsung?sort=gia-cao-den-thap&trang=2";
    String FPT_OPPO ="https://fptshop.com.vn/dien-thoai/oppo?sort=gia-cao-den-thap";
    String FPT_XIAOMI ="https://fptshop.com.vn/dien-thoai/xiaomi?sort=gia-cao-den-thapp";

    String NORMAL_REGEX = "'Home','(.*)',(.*?),(.*?),0000,(.*)href=\"(.*)\" title=";
    String SAMSUNG_REGEX = "'Home','(S.*)',(.*?),(.*?),0000,(.*)href=\"(.*)\" title=";
    void crawl_Product(String link,String regex);
}
