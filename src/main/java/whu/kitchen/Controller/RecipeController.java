//Author:刘行
package whu.kitchen.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import whu.kitchen.Service.HowToDoService;
import whu.kitchen.Service.RecipeService;

@RestController
public class RecipeController {
    @Autowired
    private RecipeService recipeService;
    @Autowired
    private HowToDoService howToDoService;
}
