package com.rxretrofit.mingzhangyong.remoteviews;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DeathKnightMo on 15-3-24.
 */
public class Area extends BaseBean {

    private Integer id;
    private String name;
    private Integer level;
    private boolean isSelect;
    private String firstLetter;

    @SerializedName("parent")
    private Integer parent;

    @SerializedName("prov_area")
    private Area provArea;

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }


    private boolean isCheckbox = false;

    public Area getProvArea() {
        return provArea;
    }

    public void setProvArea(Area provArea) {
        this.provArea = provArea;
    }

    private SkuAgentAmount saa;//代理与上量

    public boolean isSelect() {
        return isSelect;
    }

    public void setIsSelect(boolean select) {
        isSelect = select;
    }

    public Area(String name){
        this.name = name;
    }

    //SettingActivity用到
    public Area(Integer id){
        this.id = id;
    }

    public Area(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return name;
    }

    //重写hashcode，equals方法，方便使用contains方法
    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Area){
            Area area = (Area) o;

            if(null != name && null != area.getName())
            return this.name.equals(area.getName());
        }
        return super.equals(o);
    }

    public SkuAgentAmount getSaa() {
        return saa;
    }

    public void setSaa(SkuAgentAmount saa) {
        this.saa = saa;
    }


    public boolean isCheckbox() {
        return isCheckbox;
    }

    public void setIsCheckbox(boolean isHospital) {
        this.isCheckbox = isHospital;
    }
}
