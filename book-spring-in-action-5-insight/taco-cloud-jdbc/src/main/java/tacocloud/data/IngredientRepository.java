package tacocloud.data;

import tacocloud.entity.TacoIngredient;

/**
 * TacoIngredient 的 JdbcRepository
 *
 * 查: 查询所有配料, 查询单个Ingredient
 * 增: 保存Ingredient对象
 * 
 * @author insight 
 * @since 2021/5/8
 */
public interface IngredientRepository {
    /**
     * 查询所有配料
     *
     * @return 返回配料集合
     */
    Iterable<TacoIngredient> findAll();

    /**
     * 根据 id 查询单个 Ingredient
     *
     * @param id Ingredient 的 id
     * @return 返回单个 Ingredient
     */
    TacoIngredient findById(String id);

    /**
     * 保存单个 Ingredient 对象
     *
     * @param ingredient 对象
     * @return TacoIngredient
     */
    TacoIngredient save(TacoIngredient ingredient);
}