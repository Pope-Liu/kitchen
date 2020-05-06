//Author:刘行
package whu.kitchen.Vo;

public class HowToDoVo {
    private int order;
    private String description;
    private String mediaUrl;

    public HowToDoVo() {
    }

    public HowToDoVo(int order, String description, String mediaUrl) {
        this.order = order;
        this.description = description;
        this.mediaUrl = mediaUrl;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
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
