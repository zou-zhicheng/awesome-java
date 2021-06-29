package tacocloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tacocloud.entity.Taco;
import tacocloud.entity.TacoIngredient;
import tacocloud.entity.TacoIngredient.Type;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * design taco controller
 * return design.html
 * display by TacoIngredient.Type group
 * 
 * @author insight 
 * @since 2021/4/28
 */
@Slf4j
@Controller
@RequestMapping("/design")
public class DesignController {
    /**
     * 处理获取design页面的get请求
     */
    @GetMapping
    public String showDesignForm(Model model) {
        // what ingredients we have
        List<TacoIngredient> ingredients = Arrays.asList(
                new TacoIngredient("FLTO", "Flour Tortilla", Type.WRAP),
                new TacoIngredient("COTO", "Corn Tortilla", Type.WRAP),
                new TacoIngredient("GRBF", "Ground Beef", Type.PROTEIN),
                new TacoIngredient("CARN", "Carnitas", Type.PROTEIN),
                new TacoIngredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
                new TacoIngredient("LETC", "Lettuce", Type.VEGGIES),
                new TacoIngredient("CHED", "Cheddar", Type.CHEESE),
                new TacoIngredient("JACK", "Monterrey Jack", Type.CHEESE),
                new TacoIngredient("SLSA", "Salsa", Type.SAUCE),
                new TacoIngredient("SRCR", "Sour Cream", Type.SAUCE)
        );
        // add by type group
        for (Type type : Type.values()) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
        // add Taco
        model.addAttribute("design", new Taco());

        return "design";
    }

    private List<TacoIngredient> filterByType(List<TacoIngredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

    /**
     * 处理design表单的post请求
     * 转到/order/current
     */
    @PostMapping
    public String processDesignForm(@Valid Taco taco, Errors errors) {
        if (errors.hasErrors()) {
            return "design";
        }
        log.info("Processing design: " + taco);
        //TODO: 保存 taco 到数据库
        return "redirect:/orders/current";
    }
}