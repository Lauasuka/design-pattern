package io.amoe.design.pattern.strategy;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Amoe
 */
@Getter
@AllArgsConstructor
public enum PaymentChannel {
    /**
     * alipay
     */
    ALIPAY(1, "alipay"),
    /**
     * weixin pay
     */
    WXPAY(2, "wx"),
    /**
     * union pay
     */
    UNION(3, "union");

    private Integer type;
    private String channel;

    public static String channel(Integer type) {
        PaymentChannel[] values = values();
        for (PaymentChannel item : values) {
            if (item.getType().equals(type)) {
                return item.getChannel();
            }
        }
        return "";
    }
}
