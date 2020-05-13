//Author:刘行
package whu.kitchen.Vo;

import org.springframework.web.multipart.MultipartFile;

public class UploadRecipeVo {
    private String name;
    private String author;
    private String time;
    private String[] material;
    private int difficulty;
    private int type;
    private String[] description;
    private MultipartFile[] files;

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String[] getMaterial() {
        return material;
    }

    public void setMaterial(String[] material) {
        this.material = material;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String[] getDescription() {
        return description;
    }

    public void setDescription(String[] description) {
        this.description = description;
    }

    public MultipartFile[] getFiles() {
        return files;
    }

    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }
}
