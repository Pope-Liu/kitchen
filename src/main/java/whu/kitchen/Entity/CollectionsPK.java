//Author:刘行
//Collections类的主键类
package whu.kitchen.Entity;

import java.io.Serializable;

public class CollectionsPK implements Serializable {
    private User user;
    private Recipe recipe;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
