package com.fierydevs.androidexperiments;

/**
 * Created by morep on 05-08-2017.
 */

public class ExperimentsModel {
    private String title, link, desc;
    private Class<?> destClass;

    public ExperimentsModel() {
    }

    public ExperimentsModel(String title, String desc, String link, Class<?> destClass) {
        this.title = title;
        this.desc = desc;
        this.link = link;
        this.destClass = destClass;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Class<?> getDestClass() {
        return destClass;
    }

    public void setDestClass(Class<?> destClass) {
        this.destClass = destClass;
    }
}
