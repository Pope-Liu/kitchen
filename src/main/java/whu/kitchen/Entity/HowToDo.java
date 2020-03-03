//Author:刘行
package whu.kitchen.Entity;

import javax.persistence.*;

@Entity
public class HowToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    //菜谱ID
    @ManyToOne
    @JoinColumn
    private Recipe recipe;

    //次序 非空
    @Column(nullable = false)
    private int howToDoOrder;

    //描述 非空
    @Column(nullable = false)
    private String description;

    //图片或视频 可为空
    private String mediaUrl;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public int getHowToDoOrder() {
        return howToDoOrder;
    }

    public void setHowToDoOrder(int howToDoOrder) {
        this.howToDoOrder = howToDoOrder;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }
}
