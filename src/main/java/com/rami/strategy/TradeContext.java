package com.rami.strategy;

import com.rami.vo.StockVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by Rami Stefanidis on 8/29/2017.
 */
public class TradeContext {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    private TradeStrategy tradeStrategy;

    public void tradeStocks(final Map<StockVO, Long> portfolioHolding, final StockVO stock, long quantity) {
        LOG.info("Begin trading stocks");
        tradeStrategy.tradeStocks(portfolioHolding,stock,quantity);
        LOG.info("Completed trading stocks");
    }

    public void setTradeStrategy(TradeStrategy tradeStrategy) {
        this.tradeStrategy = tradeStrategy;
    }
}
