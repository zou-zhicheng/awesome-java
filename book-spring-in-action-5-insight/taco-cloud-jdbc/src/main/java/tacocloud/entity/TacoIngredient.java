package tacocloud.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Taco配料类
 * 
 * @author insight 
 * @since 2021/4/28
 */
@Data
@RequiredArgsConstructor
public class TacoIngredient {
    private final String id;
    private final String name;
    private final Type type;

    public static enum Type {
        /**
         * 配料类型
         * 卷, 蛋, 蔬菜, 奶酪, 酱
         */
        WRAP,
        PROTEIN,
        VEGGIES,
        CHEESE,
        SAUCE,
        ;
    }
}