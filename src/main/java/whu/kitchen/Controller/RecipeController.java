//Author:刘行
package whu.kitchen.Controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import whu.kitchen.Service.HowToDoService;
import whu.kitchen.Service.RecipeService;
import whu.kitchen.Vo.HowToDoVo;
import whu.kitchen.Vo.MainRecipeVo;
import whu.kitchen.Vo.RecipeVo;
import whu.kitchen.Vo.ResultVo;

import java.util.List;

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
        RecipeVo recipeVo = recipeService.getRecipeById(Id);
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

    @PostMapping("uploadRecipe")
    public ResultVo uploadRecipe(@RequestParam("name")String name,
                                 @RequestParam("cover")MultipartFile cover,
                                 @RequestParam("author")String author,
                                 @RequestParam("time")String time,
                                 @RequestParam("material")String[] material,
                                 @RequestParam("difficulty")int difficulty,
                                 @RequestParam("howToDoList")List<HowToDoVo> howToDoVos,
                                 @RequestParam("type")int type){
        System.out.println(howToDoVos);
        return null;
    }

}
