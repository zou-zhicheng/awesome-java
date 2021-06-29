package tacocloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import tacocloud.data.IngredientRepository;
import tacocloud.data.TacoRepository;
import tacocloud.data.UserRepository;
import tacocloud.entity.Order;
import tacocloud.entity.Taco;
import tacocloud.entity.TacoIngredient;
import tacocloud.entity.TacoIngredient.Type;
import tacocloud.entity.User;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * design taco controller
 * return design.html
 * display by TacoIngredient.Type group
 *
 * 使用 SessionAttributes 注解, 指定属性保存在 session 中, 跨域使用
 *
 * @author insight 
 * @since 2021/4/28
 */
@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignController {
    private final IngredientRepository ingredientRepository;
    private final TacoRepository designRepository;
    private final UserRepository userRepository;

    @Autowired
    public DesignController(IngredientRepository ingredientRepository, TacoRepository designRepository, UserRepository userRepository) {
        this.ingredientRepository = ingredientRepository;
        this.designRepository = designRepository;
        this.userRepository = userRepository;
    }

    /**
     * 使用 ModelAttribute 注解替代每次手动创建对象
     * 会在每个处理请求的方法之前先调用一次
     */
    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute(name = "design")
    public Taco design() {
        return new Taco();
    }

    /**
     * 处理获取design页面的get请求
     * 注入 Principal 对象, 获取用户信息
     */
    @GetMapping
    public String showDesignForm(Model model, Principal principal) {
        // cancel hard code
        List<TacoIngredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(ingredients::add);

        // add by type group
        for (Type type : Type.values()) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }

        User user = userRepository.findByUsername(principal.getName());
        model.addAttribute("user", user);

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
    public String processDesignForm(@Valid Taco design, Errors errors,
                                    @ModelAttribute Order order) {
        if (errors.hasErrors()) {
            return "design";
        }

        log.info("Processing design: " + design);
        Taco save = designRepository.save(design);
        order.addDesign(save);

        return "redirect:/orders/current";
    }
}