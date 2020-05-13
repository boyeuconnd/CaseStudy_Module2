package codegym.crawl_manager;

public class Samsung extends Crawl_Phone implements Runnable {
    protected Samsung() {
    }
    Thread threadSamsung = new Thread(this::run);
    @Override
    public void run() {
        this.crawl_Product(FPT_SHOP_SAMSUNG,SAMSUNG_REGEX);
    }
}
