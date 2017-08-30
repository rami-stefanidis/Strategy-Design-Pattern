package com.rami.Configuration;

import com.rami.factory.TradingStrategyFactory;
import com.rami.strategy.BuyStrategy;
import com.rami.strategy.SellStrategy;
import com.rami.strategy.TradeContext;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Rami Stefanidis on 8/29/2017.
 */
@Configuration
public class ApplicationConfig {


    //name must match enum so serviceLocatorFactoryBean can resolve to correct bean
    @Bean(name = "BUY")
    public TradeContext buyTradeContext() {
        final TradeContext tradeContext = new TradeContext();
        tradeContext.setTradeStrategy(new BuyStrategy());
        return  tradeContext;
    }

    //name must match enum so serviceLocatorFactoryBean can resolve to correct bean
    @Bean(name = "SELL")
    public TradeContext sellTradeContext() {
        final TradeContext tradeContext = new TradeContext();
        tradeContext.setTradeStrategy(new SellStrategy());
        return tradeContext;
    }


    @Bean
    public FactoryBean serviceLocatorFactoryBean() {
        ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
        factoryBean.setServiceLocatorInterface(TradingStrategyFactory.class);
        return factoryBean;
    }
}
