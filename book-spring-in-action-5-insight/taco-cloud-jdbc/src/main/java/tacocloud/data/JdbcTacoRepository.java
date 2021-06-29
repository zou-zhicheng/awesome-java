package tacocloud.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import tacocloud.entity.Taco;
import tacocloud.entity.TacoIngredient;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

/**
 * 保存 taco 的时候需要同时将与该 taco 关联的配料保存到 Taco_Ingredients 中
 * 使用 update 保存
 * 
 * @author insight 
 * @since 2021/5/8
 */
@Repository
public class JdbcTacoRepository implements TacoRepository {
    private JdbcTemplate jdbc;

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) { this.jdbc = jdbc; }

    /**
     * 先保存 Taco 的基本信息, 再保存相关配料
     */
    @Override
    public Taco save(Taco design) {
        long tacoId = saveTacoInfo(design);
        design.setId(tacoId);

        design.getIngredients().forEach(i -> saveIngredientToTaco(i, tacoId));

        return design;
    }

    /**
     * 保存 Taco 的基本信息
     *
     * 为了获取保存后的 id, 需要使用update(PreparedStatementCreator, KeyHolder)
     * 创建 PreparedStatementCreator:
     * 1. 创建 PreparedStatementCreatorFactory, 传递 sql 语句 & 参数类型
     * 2. 调用工厂类 newPreparedStatementCreator, 传递参数值
     *
     * 使用 KeyHolder 可以获取 id
     */
    private long saveTacoInfo(Taco taco) {
        taco.setCreatedAt(new Date());
        PreparedStatementCreatorFactory preparedStatementCreatorFactory =
                new PreparedStatementCreatorFactory(
                "insert into Taco (name, createdAt) values (?, ?)",
                Types.VARCHAR, Types.TIMESTAMP
        );
        // 设置可以返回 key
        preparedStatementCreatorFactory.setReturnGeneratedKeys(true);

        PreparedStatementCreator psc =
                preparedStatementCreatorFactory.newPreparedStatementCreator(
                        Arrays.asList(
                                taco.getName(),
                                new Timestamp(taco.getCreatedAt().getTime())));

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(psc, keyHolder);

        return Objects.requireNonNull(keyHolder.getKey()).longValue();
    }

    /**
     * 保存配料信息
     */
    private void saveIngredientToTaco(
            TacoIngredient ingredient, long tacoId) {
        jdbc.update(
                "insert into Taco_Ingredients (taco, ingredient) " +
                        "values (?, ?)",
                tacoId, ingredient.getId());
    }
}