package com.rami.strategy;

import com.rami.vo.StockVO;

import java.util.Map;

/**
 * Created by Rami Stefanidis on 8/29/2017.
 */
public interface TradeStrategy {

    void tradeStocks(final Map<StockVO,Long> portfolioHolding, final StockVO stockVO, final long quantity);
}
