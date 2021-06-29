package tacocloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import tacocloud.data.IngredientRepository;
import tacocloud.entity.TacoIngredient;

import java.util.Optional;

@Component
public class IngredientByIdConverter implements Converter<String,
        TacoIngredient> {

    private IngredientRepository ingredientRepo;

    @Autowired
    public IngredientByIdConverter(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @Override
    public TacoIngredient convert(String id) {
        Optional<TacoIngredient> optionalIngredient =
                ingredientRepo.findById(id);
        return optionalIngredient.orElse(null);
    }

}
