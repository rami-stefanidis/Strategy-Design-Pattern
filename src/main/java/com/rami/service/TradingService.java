package com.rami.service;

import com.rami.factory.TradingStrategyFactory;
import com.rami.strategy.TradeContext;
import com.rami.vo.StockVO;
import com.rami.factory.TradeExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Rami Stefanidis on 8/29/2017.
 */
@Service
public class TradingService {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TradingStrategyFactory tradingStrategyFactory;

    public void tradeStocks(final Map<StockVO, Long> portfolio, final StockVO stock, final long quantity,final TradeExecution tradeExecution) {
        LOG.info("Begin Trading Stocks. TradeExecution = {}",tradeExecution);
        final TradeContext tradeContext = tradingStrategyFactory.getTradeContext(tradeExecution);
        tradeContext.tradeStocks(portfolio,stock,quantity);
        LOG.info("Completed Trading Stocks. TradeExecution = {}",tradeExecution);
    }

}
