package io.amoe.design.pattern.strategy.impl;

import io.amoe.design.pattern.strategy.IPaymentStrategy;
import io.amoe.design.pattern.strategy.PaymentChannel;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author Amoe
 * @date 2019/12/12 16:53
 */
@Component("payment.channel.wx")
public class WxpayStrategy implements IPaymentStrategy {
    private static final String ROUTING_KEY =  String.valueOf(PaymentChannel.WXPAY.getType());;

    @Override
    public void doPay(BigDecimal amount) {
        System.out.println("使用微信支付 " + amount + " 元");
    }

    @Override
    public String getPaymentKey() {
        return ROUTING_KEY;
    }
}
