//Author:刘行
package whu.kitchen.Vo;

import whu.kitchen.Entity.HowToDo;

import java.util.List;
import java.util.Map;

public class RecipeInfoVo {
    private int Id;
    private String name;
    private String cover;
    private String author;
    private String time;
    private Map<String, String> material;
    private int type;
    private int difficulty;
    private double score;
    private int collectionNumber;
    private int browseNumber;
    private List<HowToDoVo> howToDoVoList;

    public RecipeInfoVo() {
    }

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

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Map<String, String> getMaterial() {
        return material;
    }

    public void setMaterial(Map<String, String> material) {
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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
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

    public List<HowToDoVo> getHowToDoVoList() {
        return howToDoVoList;
    }

    public void setHowToDoVoList(List<HowToDoVo> howToDoVoList) {
        this.howToDoVoList = howToDoVoList;
    }

    @Override
    public String toString() {
        return "RecipeVo{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", cover='" + cover + '\'' +
                ", author='" + author + '\'' +
                ", time='" + time + '\'' +
                ", material=" + material +
                ", type=" + type +
                ", difficulty=" + difficulty +
                ", score=" + score +
                ", collectionNumber=" + collectionNumber +
                ", browseNumber=" + browseNumber +
                ", howToDoVoList=" + howToDoVoList +
                '}';
    }
}
