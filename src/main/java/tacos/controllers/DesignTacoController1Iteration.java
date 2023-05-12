package tacos.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.context.request.RequestContextHolder;
import tacos.domain.Ingredient;
import tacos.domain.Ingredient.Type;
import tacos.domain.Order;
import tacos.domain.Taco;
import tacos.repository.IngredientRepository;
import tacos.repository.TacoRepository;

import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/")
@SessionAttributes("order")
public class DesignTacoController1Iteration {

    private final IngredientRepository ingredientRepository;
    private final TacoRepository tacoRepository;

    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute(name = "design")
    public Taco design() {
        return new Taco();
    }

    @Autowired
    public DesignTacoController1Iteration(IngredientRepository ingredientRepository, TacoRepository tacoRepository) {
        this.ingredientRepository = ingredientRepository;
        this.tacoRepository = tacoRepository;
    }

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(e -> ingredients.add(e));

        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
        model.addAttribute("design", new Taco());

        return "design";
    }

    @PostMapping
    public String processDesign(@RequestBody Taco taco, Errors error,
                                @ModelAttribute Order order) {
//        if (error.hasErrors()) {
//            return "design";
//        }
        log.info("Processing design: " + taco);
        Taco saved = tacoRepository.save(taco);
        order.addDesign(saved);
        log.info("session id: " + RequestContextHolder.currentRequestAttributes().getSessionId());
        return "redirect:/orders/current";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients.stream()
                .filter(i -> i.getType().equals(type))
                .collect(Collectors.toList());
    }
}
