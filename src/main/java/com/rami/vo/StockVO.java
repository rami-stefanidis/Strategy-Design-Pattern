package com.rami.vo;

import java.math.BigDecimal;

/**
 * Created by Rami Stefanidis on 8/29/2017.
 */
public class StockVO {

    private final String ticker;
    private final BigDecimal price;

    public StockVO(final String ticker,final BigDecimal price) {
        this.ticker = ticker;
        this.price=price;
    }

    public String getTicker() {
        return ticker;
    }

    private BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "StockVO{" +
                "ticker='" + ticker + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StockVO)) return false;

        StockVO stockVO = (StockVO) o;

        if (getTicker() != null ? !getTicker().equals(stockVO.getTicker()) : stockVO.getTicker() != null) return false;
        return getPrice() != null ? getPrice().equals(stockVO.getPrice()) : stockVO.getPrice() == null;
    }

    @Override
    public int hashCode() {
        int result = getTicker() != null ? getTicker().hashCode() : 0;
        result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
        return result;
    }
}
