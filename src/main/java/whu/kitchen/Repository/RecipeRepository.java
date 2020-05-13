package whu.kitchen.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import whu.kitchen.Entity.Recipe;
import whu.kitchen.Vo.MainRecipeVo;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe,Integer> {

    //分页查询，每一页10条数据
    @Query("select new whu.kitchen.Vo.MainRecipeVo(r.Id,r.name,r.cover,r.collectionNumber,r.browseNumber) from Recipe r ")
    Page<MainRecipeVo> getMainRecipeVoPagesByBrowseNumber(Pageable pageable);

    @Query("select new whu.kitchen.Vo.MainRecipeVo(r.Id,r.name,r.cover,r.collectionNumber,r.browseNumber) from Recipe r where r.name like ?1")
    List<MainRecipeVo> findByNameLike(String name);
    @Query("select new whu.kitchen.Vo.MainRecipeVo(r.Id,r.name,r.cover,r.collectionNumber,r.browseNumber) from Recipe r where r.material like ?1")
    List<MainRecipeVo> findByMaterialLike(String material);

}
