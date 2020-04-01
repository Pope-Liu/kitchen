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
    private String name;

    //菜谱作者
    @Column(nullable = false)
    private String author = "系统";

    //菜谱材料 非空 （列表型字符串）
    @Column(nullable = false)
    private String material;

    //烹饪类型 非空
    @Column(nullable = false, precision = 1)
    private int type;

    //菜谱困难度 非空
    @Column(nullable = false, precision = 1)
    private int difficulty;

    //菜谱评分 非空 默认值为0
    @Column(nullable = false, precision = 1)
    private int score = 0;

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

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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
