package codegym.crawl_manager;

public class Oppo extends Crawl_Phone implements Runnable {
    public Oppo() {
    }
    Thread threadOppo = new Thread(this);

    @Override
    public void run() {
        this.crawl_Product(FPT_OPPO, NORMAL_REGEX);
    }
}
