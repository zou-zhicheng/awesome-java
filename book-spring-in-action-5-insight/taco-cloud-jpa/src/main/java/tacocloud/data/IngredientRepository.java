package tacocloud.data;

import org.springframework.data.repository.CrudRepository;
import tacocloud.entity.TacoIngredient;

public interface IngredientRepository 
         extends CrudRepository<TacoIngredient, String> {

}
