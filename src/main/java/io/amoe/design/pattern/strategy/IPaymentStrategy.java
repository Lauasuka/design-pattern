package io.amoe.design.pattern.strategy;

import java.math.BigDecimal;

/**
 * @author Amoe
 */
public interface IPaymentStrategy {
    void doPay(BigDecimal amount);

    String getPaymentKey();
}
