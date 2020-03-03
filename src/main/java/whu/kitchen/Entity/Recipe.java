//Author:刘行
package whu.kitchen.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Recipe {

    //菜谱ID 主键 自增 与做法为一对多关系
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    //菜谱名 非空
    @Column(nullable = false)
    private String recipeName;

    //菜谱材料 非空 （列表型字符串）
    @Column(nullable = false)
    private String recipeMaterial;

    //烹饪类型 非空
    @Column(nullable = false, precision = 1)
    private int recipeType;

    //菜谱困难度 非空
    @Column(nullable = false, precision = 1)
    private int recipeDifficulty;

    //菜谱评分 非空 默认值为0
    @Column(nullable = false, precision = 1)
    private int recipeScore = 0;

    //收藏人数 非空 默认值为0
    @Column(nullable = false)
    private int collectionNumber = 0;

    //浏览数 非空 默认为0
    @Column(nullable = false)
    private int browseNumber = 0;

    //菜的做法 菜谱与做法为一对多关系
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<HowToDo> howToDoList;

    //收藏 一道菜可以对应很多个用户的收藏记录 一对多
    @OneToMany(mappedBy = "recipe",cascade = CascadeType.ALL)
    private List<Collections> collectionsList;


    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeMaterial() {
        return recipeMaterial;
    }

    public void setRecipeMaterial(String recipeMaterial) {
        this.recipeMaterial = recipeMaterial;
    }

    public int getRecipeType() {
        return recipeType;
    }

    public void setRecipeType(int recipeType) {
        this.recipeType = recipeType;
    }

    public int getRecipeDifficulty() {
        return recipeDifficulty;
    }

    public void setRecipeDifficulty(int recipeDifficulty) {
        this.recipeDifficulty = recipeDifficulty;
    }

    public int getRecipeScore() {
        return recipeScore;
    }

    public void setRecipeScore(int recipeScore) {
        this.recipeScore = recipeScore;
    }

    public int getCollectionNumber() {
        return collectionNumber;
    }

    public void setCollectionNumber(int collectionNumber) {
        this.collectionNumber = collectionNumber;
    }

    public int getBrowseNumber() {
        return browseNumber;
    }

    public void setBrowseNumber(int browseNumber) {
        this.browseNumber = browseNumber;
    }
}
