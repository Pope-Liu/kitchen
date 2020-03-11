package whu.kitchen.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import whu.kitchen.Entity.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe,Integer> {

}
