package br.com.renandeldotti.devventurefinaltest.model;

import java.util.ArrayList;
import java.util.List;

public class Cat {

    private List<Data> data = new ArrayList<>();

    public Cat(List<Data> data) {
        this.data = data;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    static class Data {
        private String id;
        private String title;
        private List<Images> images = new ArrayList<>();

        public Data(String id, String title, List<Images> images) {
            this.id = id;
            this.title = title;
            this.images = images;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<Images> getImages() {
            return images;
        }

        public void setImages(List<Images> images) {
            this.images = images;
        }
    }

    static class Images {
        private String link;

        public Images(String link) {
            this.link = link;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }
    }

    /*private String catImageId;
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
    }*/
}
