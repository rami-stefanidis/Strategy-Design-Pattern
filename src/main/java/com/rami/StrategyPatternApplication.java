package com.rami;

import com.rami.service.TradingService;
import com.rami.vo.StockVO;
import com.rami.factory.TradeExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Author: Rami Stefanidis
 *
 */
@SpringBootApplication
public class StrategyPatternApplication implements CommandLineRunner
{
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TradingService tradingService;

    private final StockVO ibmStock = new StockVO("IBM", new BigDecimal("103.3"));
    private final StockVO msftStock = new StockVO("MSFT",new BigDecimal("98.1"));
    private final StockVO nflxStock = new StockVO("NFLX", new BigDecimal("1068.81"));

    public static void main( String[] args )
    {
        SpringApplication.run(StrategyPatternApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        final Map<StockVO,Long> portfolio = getSamplePortfolio();

        tradingService.tradeStocks(portfolio,ibmStock,50, TradeExecution.BUY);
        tradingService.tradeStocks(portfolio,nflxStock,25, TradeExecution.BUY);
        tradingService.tradeStocks(portfolio,msftStock,10, TradeExecution.SELL);

        portfolio.forEach((stock,holding) -> {
           LOG.info("After trading, have {} of {}",stock.getTicker(),holding);
        });

    }


    private Map<StockVO,Long> getSamplePortfolio() {

        final Map<StockVO,Long> portfolio = new HashMap<>();
        portfolio.put(ibmStock,100L);
        portfolio.put(msftStock,200L);
        portfolio.put(nflxStock,300L);

        return portfolio;

    }
}
