package com.rami.factory;

import com.rami.strategy.TradeContext;
import org.springframework.stereotype.Component;

/**
 * Created by Rami Stefanidis on 8/29/2017.
 */
@Component
public interface TradingStrategyFactory {

    TradeContext getTradeContext(TradeExecution tradeExecution);
}
