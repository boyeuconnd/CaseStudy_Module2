package codegym.crawl_manager;

public class Iphone extends Crawl_Phone implements Runnable {
    protected Iphone() {
    }
    Thread threadIphone = new Thread(this);

    @Override
    public void run() {
        this.crawl_Product(FPT_IPHONE, NORMAL_REGEX);
    }
}
