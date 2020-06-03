package br.com.renandeldotti.devventurefinaltest.model;

public class Cat {

    private String catImageId;
    private String catImageTitle;
    private String catImageUrl;

    public Cat() {}

    public Cat(String catImageId, String catImageTitle, String catImageUrl) {
        this.catImageId = catImageId;
        this.catImageTitle = catImageTitle;
        this.catImageUrl = catImageUrl;
    }

    public String getCatImageId() {
        return catImageId;
    }

    public void setCatImageId(String catImageId) {
        this.catImageId = catImageId;
    }

    public String getCatImageTitle() {
        return catImageTitle;
    }

    public void setCatImageTitle(String catImageTitle) {
        this.catImageTitle = catImageTitle;
    }

    public String getCatImageUrl() {
        return catImageUrl;
    }

    public void setCatImageUrl(String catImageUrl) {
        this.catImageUrl = catImageUrl;
    }
}
