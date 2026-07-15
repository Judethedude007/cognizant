package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication implements ApplicationRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private final StockService stockService;

    public OrmLearnApplication(StockService stockService) {
        this.stockService = stockService;
    }

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Inside main");
    }

    @Override
    public void run(ApplicationArguments args) {
        testGetFacebookStocksInSeptember2019();
        testGetGoogleStocksWithCloseGreaterThan1250();
        testGetTop3StocksByHighestVolume();
        testGetNetflixLowest3Stocks();
    }

    private void testGetFacebookStocksInSeptember2019() {
        LOGGER.info("Start - Facebook September 2019 stock query");

        List<Stock> stocks = stockService.getFacebookStocksInSeptember2019();

        LOGGER.debug("Facebook stocks in September 2019: {}", stocks);
        LOGGER.debug("Facebook September 2019 count: {}", stocks.size());

        LOGGER.info("End - Facebook September 2019 stock query");
    }

    private void testGetGoogleStocksWithCloseGreaterThan1250() {
        LOGGER.info("Start - Google stock close greater than 1250 query");

        List<Stock> stocks = stockService.getGoogleStocksWithCloseGreaterThan1250();

        LOGGER.debug("Google stocks with close greater than 1250: {}", stocks);
        LOGGER.debug("Google close greater than 1250 count: {}", stocks.size());

        LOGGER.info("End - Google stock close greater than 1250 query");
    }

    private void testGetTop3StocksByHighestVolume() {
        LOGGER.info("Start - top 3 highest volume stock query");

        List<Stock> stocks = stockService.getTop3StocksByHighestVolume();

        LOGGER.debug("Top 3 highest volume stocks: {}", stocks);
        LOGGER.debug("Top 3 highest volume count: {}", stocks.size());

        LOGGER.info("End - top 3 highest volume stock query");
    }

    private void testGetNetflixLowest3Stocks() {
        LOGGER.info("Start - Netflix lowest 3 stock query");

        List<Stock> stocks = stockService.getNetflixLowest3Stocks();

        LOGGER.debug("Netflix lowest 3 stocks: {}", stocks);
        LOGGER.debug("Netflix lowest 3 count: {}", stocks.size());

        LOGGER.info("End - Netflix lowest 3 stock query");
    }
}
