package whu.kitchen.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import whu.kitchen.Entity.HowToDo;
import whu.kitchen.Entity.Recipe;
import whu.kitchen.Vo.HowToDoVo;

import java.util.List;

public interface HowToDoRepository extends JpaRepository<HowToDo, Integer> {

    @Query("select new whu.kitchen.Vo.HowToDoVo(htd.howToDoOrder,htd.description,htd.mediaUrl) from HowToDo htd where htd.recipe = ?1 order by htd.howToDoOrder asc")
    List<HowToDoVo> getHowToDoVoByRecipeId(Recipe recipe);

}
