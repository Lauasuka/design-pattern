package io.amoe.design.pattern.common.controller;

import io.amoe.design.pattern.strategy.PaymentStrategyFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author Amoe
 */
@Slf4j
@Controller
public class DesignPatternController {

    @Resource
    private PaymentStrategyFactory paymentStrategyFactory;

    @GetMapping("payment")
    public void paymentStrategy(Integer channel, BigDecimal amount) {
        paymentStrategyFactory.doPay(channel, amount);
    }
}
