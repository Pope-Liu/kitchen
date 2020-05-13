//Author:刘行
package whu.kitchen.Controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import whu.kitchen.Entity.Recipe;
import whu.kitchen.Service.HowToDoService;
import whu.kitchen.Service.RecipeService;
import whu.kitchen.Vo.MainRecipeVo;
import whu.kitchen.Vo.RecipeInfoVo;
import whu.kitchen.Vo.ResultVo;
import whu.kitchen.Vo.UploadRecipeVo;

import java.util.List;
import java.util.Map;

@Api(tags = "菜谱模块")
@RestController(value = "/recipe")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;
    @Autowired
    private HowToDoService howToDoService;

    /**
     * 获取首页菜谱，根据收藏数来推荐，每次返回十条数据
     * @param pageNumber 页数
     * @return ResultVo
     */
    @PostMapping("getMainRecipesByPageNumber")
    public ResultVo getMainRecipesByPageNumbers(@RequestParam("pageNumber")int pageNumber){
        ResultVo resultVo = new ResultVo();
        List<MainRecipeVo> recipeVos = recipeService.getRecipeByCollectionNumber(pageNumber);
        if(recipeVos.size()==0){
            resultVo.setCode(-1);
            resultVo.setMsg("已无数据！");
            resultVo.setData(null);
        }else {
            resultVo.setCode(1);
            resultVo.setMsg("查询成功！");
            resultVo.setData(recipeVos);
        }

        return resultVo;
    }

    /**
     * 根据菜谱Id来返回相应的菜谱信息
     * @param Id 菜谱Id
     * @return ResultVo
     */
    @PostMapping("getRecipeInfoById")
    public ResultVo getRecipeInfoById(@RequestParam("Id")int Id){
        ResultVo resultVo = new ResultVo();
        RecipeInfoVo recipeVo = recipeService.getRecipeById(Id);
        if(recipeVo == null){
            resultVo.setCode(-2);
            resultVo.setMsg("无该菜谱信息！");
            resultVo.setData(null);
        }else {
            resultVo.setCode(2);
            resultVo.setMsg("查询成功！");
            resultVo.setData(recipeVo);
        }
        return resultVo;
    }


    /**
     * 上传菜谱
     * @param uploadRecipeVo 上传菜谱Vo
     * @return ResultVo
     */
    @PostMapping("uploadRecipe")
    public ResultVo uploadRecipe(UploadRecipeVo uploadRecipeVo){
        ResultVo resultVo = new ResultVo();
        Recipe recipe = recipeService.uploadRecipe(uploadRecipeVo);
        if(recipe == null){
            resultVo.setCode(-3);
            resultVo.setMsg("上传失败");
            resultVo.setData(null);
        }else {
            resultVo.setCode(3);
            resultVo.setMsg("上传成功");
            resultVo.setData(recipe);
        }

        return resultVo;
    }

    /**
     * 根据菜谱名进行模糊查询
     * @param name 菜谱名
     * @return ResultVo
     */
    @PostMapping("getRecipesByName")
    public ResultVo getRecipesByName(@RequestParam("name")String name){
        ResultVo resultVo = new ResultVo();
        List<MainRecipeVo> mainRecipeVoList = recipeService.getRecipesByName(name);
        if(null == mainRecipeVoList || mainRecipeVoList.size() == 0){
            resultVo.setCode(-4);
            resultVo.setMsg("查询失败");
            resultVo.setData(null);
        }else {
            resultVo.setCode(4);
            resultVo.setMsg("查询成功");
            resultVo.setData(mainRecipeVoList);
        }
        return resultVo;
    }

    @PostMapping("getRecipesByMaterial")
    public ResultVo getRecipesByMaterial(@RequestParam("material")String material){
        ResultVo resultVo = new ResultVo();
        List<MainRecipeVo> mainRecipeVoList = recipeService.getRecipesByMaterial(material);
        if(null == mainRecipeVoList || mainRecipeVoList.size() == 0){
            resultVo.setCode(-5);
            resultVo.setMsg("查询失败");
            resultVo.setData(null);
        }else {
            resultVo.setCode(5);
            resultVo.setMsg("查询成功");
            resultVo.setData(mainRecipeVoList);
        }
        return resultVo;
    }

}
