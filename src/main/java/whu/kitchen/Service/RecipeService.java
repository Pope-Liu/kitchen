//Author:刘行
package whu.kitchen.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import whu.kitchen.Entity.Recipe;
import whu.kitchen.Repository.HowToDoRepository;
import whu.kitchen.Repository.RecipeRepository;
import whu.kitchen.Util.ArrayAndStringUtil;
import whu.kitchen.Vo.HowToDoVo;
import whu.kitchen.Vo.MainRecipeVo;
import whu.kitchen.Vo.RecipeVo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private HowToDoRepository howToDoRepository;

    public List<MainRecipeVo> getRecipeByCollectionNumber(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber,10, Sort.Direction.DESC,"collectionNumber");
        Page<MainRecipeVo> pages = recipeRepository.getMainRecipeVoPagesByBrowseNumber(pageable);
        return pages.getContent();
    }

    public RecipeVo getRecipeById(int Id){
        RecipeVo recipeVo = new RecipeVo();
        Recipe recipe = recipeRepository.findById(Id).orElse(null);
        if(recipe != null){
            recipeVo.setId(recipe.getId());
            recipeVo.setName(recipe.getName());
            recipeVo.setCover(recipe.getCover());
            recipeVo.setAuthor(recipe.getAuthor());
            recipeVo.setTime(recipe.getTime());
            recipeVo.setType(recipe.getType());
            recipeVo.setDifficulty(recipe.getDifficulty());
            recipeVo.setScore(recipe.getScore());
            recipeVo.setBrowseNumber(recipe.getBrowseNumber());
            recipeVo.setCollectionNumber(recipe.getCollectionNumber());
            String[] materialStrs = ArrayAndStringUtil.StringToArray(recipe.getMaterial());
            Map<String,String> material = new HashMap<>();
            for(int i = 0; i < materialStrs.length;){
                material.put(materialStrs[i],materialStrs[i+1]);
                i += 2;
            }
            recipeVo.setMaterial(material);
            List<HowToDoVo> howToDoVos = howToDoRepository.getHowToDoVoByRecipeId(recipe);
            recipeVo.setHowToDoVoList(howToDoVos);
            return recipeVo;
        }else {
            return null;
        }
    }


}
