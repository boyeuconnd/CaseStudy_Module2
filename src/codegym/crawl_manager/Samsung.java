package codegym.crawl_manager;

public class Samsung extends Crawl_Phone implements Runnable {
    protected Samsung() {
    }
    Thread threadSamsung = new Thread(this::run);
    @Override
    public void run() {
        this.crawl_Product(FPT_SAMSUNG_1,SAMSUNG_REGEX);
        this.crawl_Product(FPT_SAMSUNG_2,SAMSUNG_REGEX);
    }
}
