package tacocloud.data;

import tacocloud.entity.Order;

/**
 * @author insight
 * @since 2021/5/8
 */
public interface OrderRepository {
    /**
     * 保存订单
     *
     * @param order 订单
     * @return 返回订单
     */
    Order save(Order order);
}