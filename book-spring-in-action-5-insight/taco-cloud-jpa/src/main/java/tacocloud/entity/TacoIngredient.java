package tacocloud.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(force=true)
@Entity
@Table(name = "Ingredient")
public class TacoIngredient {
  
  @Id
  private final String id;
  private final String name;

  /**
   * 修了一下午 问题之一出在这
   * design 页面 String, 此处是Type 需要声明为字符串
   */
  @Enumerated(EnumType.STRING)
  private final Type type;

  public enum Type {
    /**
     * 配料
     */
    WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
  }

}
