package tacocloud.data;

import tacocloud.entity.Taco;

/**
 * @author insight
 * @since 2021/5/8
 */
public interface TacoRepository {
    /**
     * 保存设计完成的 Taco
     *
     * @param design 设计完成的 Taco 对象
     * @return 返回 Taco 对象
     */
    Taco save(Taco design);
}