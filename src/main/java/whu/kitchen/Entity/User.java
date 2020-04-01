//Author:刘行
package whu.kitchen.Entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class User {

    //用户ID 主键 自增
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    //用户电话 注册用 非空 最大长度为11
    @Column(nullable = false, precision = 11)
    private String tel;

    //用户昵称 非空 默认值为手机号 最大长度为16字节
    @Column(nullable = false, precision = 16)
    private String nickname = this.tel + "";

    //用户密码 非空 最短长度为8 最大长度为16
    @Size(min = 8,max = 16)
    @Column(nullable = false, length = 16)
    private String password;

    //用户头像 非空 有默认值
    @Column(nullable = false)
    private String head;

    //收藏 一个用户收藏记录中可以有很多菜 一对多
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Collections> collectionsList;


    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }
}
