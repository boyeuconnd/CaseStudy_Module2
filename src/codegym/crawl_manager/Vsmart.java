package codegym.crawl_manager;

public class Vsmart extends Crawl_Phone implements Runnable {
    protected Vsmart() {
    }
    Thread threadVsmart = new Thread(this);
    @Override
    public void run() {
        this.crawl_Product(FPT_VSMART,NORMAL_REGEX);
    }
}
