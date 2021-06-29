package tacocloud.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import tacocloud.entity.TacoIngredient;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * 
 * @author insight 
 * @since 2021/5/8
 */
@Repository
public class JdbcIngredientRepository implements IngredientRepository {
    private JdbcTemplate jdbc;

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) { this.jdbc = jdbc; }

    /**
     * query 返回对象List
     */
    @Override
    public Iterable<TacoIngredient> findAll() {
        return jdbc.query("select id, name, type from Ingredient",
                this::mapRowToIngredient);
    }

    /**
     * queryForObject 返回单个对象
     */
    @Override
    public TacoIngredient findById(String id) {
        return jdbc.queryForObject(
                "select id, name, type from Ingredient where id=?",
                this::mapRowToIngredient, id);
    }

    /*
    也可以使用显式 RowMapper
    @Override
    public Ingredient findOne(String id) {
    return jdbc.queryForObject(
        "select id, name, type from Ingredient where id=?",
        new RowMapper<Ingredient>() {
          public Ingredient mapRow(ResultSet rs, int rowNum)
              throws SQLException {
            return new Ingredient(
                rs.getString("id"),
                rs.getString("name"),
                Ingredient.Type.valueOf(rs.getString("type")));
          };
        }, id);
    }
     */

    @Override
    public TacoIngredient save(TacoIngredient ingredient) {
        jdbc.update(
                "insert into Ingredient (id, name, type) values (?, ?, ?)",
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getType().toString());
        return ingredient;
    }

    /**
     * Spring RowMapper 一个实现
     * 把查询到的每行数据映射为一个对象
     */
    private TacoIngredient mapRowToIngredient(ResultSet rs, int rowNum) throws SQLException {
        return new TacoIngredient(
                rs.getString("id"),
                rs.getString("name"),
                TacoIngredient.Type.valueOf(rs.getString("type")));
    }
}