package tacocloud.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import tacocloud.entity.Order;
import tacocloud.entity.Taco;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 使用 SimpleJdbcInsert 替代 PreparedStatementCreator
 * 
 * @author insight 
 * @since 2021/5/8
 */
@Repository
public class JdbcOrderRepository implements OrderRepository {
    private SimpleJdbcInsert orderInserter;
    private SimpleJdbcInsert orderTacoInserter;
    private ObjectMapper objectMapper;

    @Autowired
    public JdbcOrderRepository(JdbcTemplate jdbc) {
        this.orderInserter = new SimpleJdbcInsert(jdbc)
                .withTableName("Taco_Order")
                .usingGeneratedKeyColumns("id");

        this.orderTacoInserter = new SimpleJdbcInsert(jdbc)
                .withTableName("Taco_Order_Tacos");

        this.objectMapper = new ObjectMapper();
    }

    /**
     * 保存订单 获取 id
     * 保存订单的每个 taco
     */
    @Override
    public Order save(Order order) {
        order.setCreatedAt(new Date());
        long orderId = saveOrderDetails(order);
        List<Taco> tacos = order.getTacos();
        tacos.forEach(i -> saveTacoToOrder(i, orderId));

        return order;
    }

    /**
     * 使用 executeAndReturnKey(Map<String, Object>) 返回 id
     * String 对应列名, Object 对应实际值
     *
     * Order有很多属性，这些属性与对应的列有着相同的名称
     * 因此使用 Jackson 的 ObjectMapper 及 convertValue() , 将 Order 转换为 Map
     * 可以使用其他方法来创建需要的 Map
     */
    private long saveOrderDetails(Order order) {
        @SuppressWarnings("unchecked")
        Map<String, Object> values =
                objectMapper.convertValue(order, Map.class);
        values.put("placedAt", order.getCreatedAt());

        return orderInserter
                        .executeAndReturnKey(values)
                        .longValue();
    }

    /**
     * 没有使用 ObjectMapper 将对象转换为 Map
     * 直接创建了一个 Map 并设置对应的值
     * 简单地调用 orderTacoInserter 的 execute() 就能执行插入操作
     */
    private void saveTacoToOrder(Taco taco, long orderId) {
        Map<String, Object> values = new HashMap<>(8);
        values.put("tacoOrder", orderId);
        values.put("taco", taco.getId());
        orderTacoInserter.execute(values);
    }
}