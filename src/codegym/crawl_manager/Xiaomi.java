package codegym.crawl_manager;

public class Xiaomi extends Crawl_Phone implements Runnable {
    protected Xiaomi() {
    }
    Thread threadXiaomi = new Thread(this::run);

    @Override
    public void run() {
        this.crawl_Product(FPT_XIAOMI, NORMAL_REGEX);
    }
}
