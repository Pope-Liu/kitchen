//Author:刘行
package whu.kitchen.Entity;

import javax.persistence.*;

@IdClass(CollectionsPK.class)
@Entity
public class Collections {

    //主键 用户id
    @Id
    @ManyToOne
    @JoinColumn
    private User user;

    //主键 菜谱id
    @Id
    @ManyToOne
    @JoinColumn
    private Recipe recipe;

}
