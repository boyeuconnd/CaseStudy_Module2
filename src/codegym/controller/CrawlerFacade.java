package codegym.controller;

import codegym.crawl_manager.Crawl_Phone;

public class CrawlerFacade {
    private CrawlerFacade() {}
    public synchronized static CrawlerFacade getInstance(){
        if(instance==null){
            instance = new CrawlerFacade();
        }
        return instance;
    }
    private static CrawlerFacade instance;
    public void startCrawler(){
        Crawl_Phone crawl_phone = new Crawl_Phone();
        crawl_phone.startThread();
    }
}
