//Author:刘行
package whu.kitchen.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import whu.kitchen.Entity.HowToDo;
import whu.kitchen.Entity.Recipe;
import whu.kitchen.Repository.HowToDoRepository;
import whu.kitchen.Repository.RecipeRepository;
import whu.kitchen.Util.ArrayAndStringUtil;
import whu.kitchen.Vo.HowToDoVo;
import whu.kitchen.Vo.MainRecipeVo;
import whu.kitchen.Vo.RecipeInfoVo;
import whu.kitchen.Vo.UploadRecipeVo;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private HowToDoRepository howToDoRepository;

    @Value("${filePath}")
    private String path;

    @Value("${staticPath}")
    private String staticPath;


    public List<MainRecipeVo> getRecipeByCollectionNumber(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 10, Sort.Direction.DESC, "collectionNumber");
        Page<MainRecipeVo> pages = recipeRepository.getMainRecipeVoPagesByBrowseNumber(pageable);
        return pages.getContent();
    }

    public RecipeInfoVo getRecipeById(int Id) {
        RecipeInfoVo recipeInfoVo = new RecipeInfoVo();
        Recipe recipe = recipeRepository.findById(Id).orElse(null);
        if (recipe != null) {
            recipe.setBrowseNumber(recipe.getBrowseNumber() + 1);
            recipeRepository.save(recipe);

            recipeInfoVo.setId(recipe.getId());
            recipeInfoVo.setName(recipe.getName());
            recipeInfoVo.setCover(recipe.getCover());
            recipeInfoVo.setAuthor(recipe.getAuthor());
            recipeInfoVo.setTime(recipe.getTime());
            recipeInfoVo.setType(recipe.getType());
            recipeInfoVo.setDifficulty(recipe.getDifficulty());
            recipeInfoVo.setScore(recipe.getScore());
            recipeInfoVo.setBrowseNumber(recipe.getBrowseNumber());
            recipeInfoVo.setCollectionNumber(recipe.getCollectionNumber());
            String[] materialStrs = ArrayAndStringUtil.StringToArray(recipe.getMaterial());
            Map<String, String> material = new HashMap<>();
            for (int i = 1; i < materialStrs.length; i += 2) {
                material.put(materialStrs[i - 1], materialStrs[i]);
            }
            recipeInfoVo.setMaterial(material);
            List<HowToDoVo> howToDoVos = howToDoRepository.getHowToDoVoByRecipeId(recipe);
            recipeInfoVo.setHowToDoVoList(howToDoVos);
            return recipeInfoVo;
        } else {
            return null;
        }
    }

    @Transactional
    public Recipe uploadRecipe(UploadRecipeVo uploadRecipeVo) {
        Recipe recipe = new Recipe();
        recipe.setName(uploadRecipeVo.getName());
        recipe.setAuthor(uploadRecipeVo.getAuthor());
        recipe.setTime(uploadRecipeVo.getTime());
        recipe.setMaterial(ArrayAndStringUtil.ArrayToString(uploadRecipeVo.getMaterial()));
        recipe.setDifficulty(uploadRecipeVo.getDifficulty());
        recipe.setType(uploadRecipeVo.getType());

        try {
            MultipartFile cover = uploadRecipeVo.getFiles()[0];
            String coverSuffix = cover.getOriginalFilename().substring(cover.getOriginalFilename().lastIndexOf('.'));
            String newCoverName = UUID.randomUUID() + coverSuffix;
            File newCover = new File(path + newCoverName);
            File filePath = new File(path);
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            cover.transferTo(newCover);
            recipe.setCover(staticPath + newCoverName);
            Recipe _recipe = recipeRepository.save(recipe);

            for (int i = 1; i < uploadRecipeVo.getFiles().length; i++) {
                MultipartFile file = uploadRecipeVo.getFiles()[i];
                String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
                String newFileName = UUID.randomUUID() + suffix;
                File newFile = new File(path + newFileName);
                file.transferTo(newFile);
                HowToDo howToDo = new HowToDo();
                howToDo.setHowToDoOrder(i - 1);
                howToDo.setDescription(uploadRecipeVo.getDescription()[i - 1]);
                howToDo.setMediaUrl(staticPath + newFileName);
                howToDo.setRecipe(_recipe);
                howToDoRepository.save(howToDo);
            }
        } catch (IOException e) {
            return null;
        }
        return recipe;
    }

    public List<MainRecipeVo> getRecipesByName(String name) {
        return recipeRepository.findByNameLike("%" + name + "%");
    }

    public List<MainRecipeVo> getRecipesByMaterial(String material) {
        return recipeRepository.findByMaterialLike("%" + material + "%");
    }
}
