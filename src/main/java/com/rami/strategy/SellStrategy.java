package com.rami.strategy;

import com.rami.vo.StockVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by Rami Stefanidis on 8/29/2017.
 */
@Component
public class SellStrategy implements TradeStrategy {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Override
    public void tradeStocks(final Map<StockVO, Long> portfolioHolding, final StockVO stockToSell, long quantityToSell) {
        LOG.info("*** Attempting to sell {} stocks of {}. ***", quantityToSell, stockToSell.getTicker());
        final Long currentHolding = portfolioHolding.get(stockToSell);
        final Long newQuantityHolding = currentHolding - quantityToSell;
        portfolioHolding.put(stockToSell,newQuantityHolding);
        LOG.info("*** Sale of {} stocks of {} is complete. Previous Holding = {} , New Holding = {} ***",stockToSell.getTicker(),quantityToSell,currentHolding,newQuantityHolding);
    }
}
