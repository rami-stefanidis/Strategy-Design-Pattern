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
public class BuyStrategy implements TradeStrategy {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());


    @Override
    public void tradeStocks(final Map<StockVO, Long> portfolioHolding, final StockVO stockToBuy, final long quantityToBuy) {
        LOG.info("*** Attempting to buy {} stocks of {}. ***", quantityToBuy, stockToBuy.getTicker());
        final Long currentHolding = portfolioHolding.get(stockToBuy);
        final Long newQuantityHolding = currentHolding + quantityToBuy;
        portfolioHolding.put(stockToBuy,newQuantityHolding);
        LOG.info("*** Purchase of {} stocks of {} is complete. Previous Holding = {} , New Holding = {} ***",stockToBuy.getTicker(),quantityToBuy,currentHolding,newQuantityHolding);
    }
}
