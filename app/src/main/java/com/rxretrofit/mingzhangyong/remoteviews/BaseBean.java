package com.rxretrofit.mingzhangyong.remoteviews;

import java.io.Serializable;

/**
 * Created by DeathKnightMo on 15-5-13.
 * 简单返回结果
 */
public class BaseBean implements Serializable {
    protected Integer status;
    protected String detail;
    protected String state;

    public BaseBean() {

    }

    public BaseBean(String detail) {
        this.detail = detail;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
