package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class StockService {

    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Transactional(readOnly = true)
    public List<Stock> getFacebookStocksInSeptember2019() {
        return stockRepository.findByCodeAndDateBetween(
                "FB",
                LocalDate.of(2019, 9, 1),
                LocalDate.of(2019, 9, 30)
        );
    }

    @Transactional(readOnly = true)
    public List<Stock> getGoogleStocksWithCloseGreaterThan1250() {
        return stockRepository.findByCodeAndCloseGreaterThan(
                "GOOGL",
                new BigDecimal("1250")
        );
    }

    @Transactional(readOnly = true)
    public List<Stock> getTop3StocksByHighestVolume() {
        return stockRepository.findTop3ByOrderByVolumeDesc();
    }

    @Transactional(readOnly = true)
    public List<Stock> getNetflixLowest3Stocks() {
        return stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX");
    }
}
