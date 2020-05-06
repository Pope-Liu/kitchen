//Author:刘行
package whu.kitchen.Vo;

public class MainRecipeVo {
    private int Id;
    private String name;
    private String cover;
    private int collectionNumber;
    private int browseNumber;

    public MainRecipeVo(int Id, String name, String cover, int collectionNumber, int browseNumber) {
        this.Id = Id;
        this.name = name;
        this.cover = cover;
        this.collectionNumber = collectionNumber;
        this.browseNumber = browseNumber;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
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
