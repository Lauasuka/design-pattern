package io.amoe.design.pattern.strategy;

import io.amoe.design.pattern.common.utils.SpringContextUtils;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 使用DependsOn告诉spring当前类初始化需要依赖SpringContextUtils
 * @author Amoe
 */
@Component
@DependsOn("SpringContextUtils")
public class PaymentStrategyFactory {
    private static final String BEAN_NAME_PREFIX = "payment.channel.";

    private ConcurrentMap<String, IPaymentStrategy> strategies = new ConcurrentHashMap<>();

    @PostConstruct
    public void initStrategies() {
        strategies = SpringContextUtils.getBeansByType(IPaymentStrategy.class);
    }

    private IPaymentStrategy route(String beanName) {
        return strategies.getOrDefault(beanName, null);
    }

    public void doPay(Integer paymentType, BigDecimal amount) {
        String beanName = BEAN_NAME_PREFIX + PaymentChannel.channel(paymentType);
        IPaymentStrategy strategy = route(beanName);
        if (strategy == null) {
            System.out.println("无此支付方式!");
            return;
        }
        strategy.doPay(amount);
    }
}
