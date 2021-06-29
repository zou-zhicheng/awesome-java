package tacocloud.data;

import org.springframework.data.repository.CrudRepository;
import tacocloud.entity.Order;

public interface OrderRepository 
         extends CrudRepository<Order, Long> {

}
