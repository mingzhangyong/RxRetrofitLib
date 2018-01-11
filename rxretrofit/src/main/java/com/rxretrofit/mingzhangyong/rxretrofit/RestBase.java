package com.rxretrofit.mingzhangyong.rxretrofit;

import java.io.Serializable;

/**
 * Created by DeathKnightMo on 15-4-5.
 * 用于异常的返回
 */
public class RestBase implements Serializable {


    protected Integer status;
    protected String detail;

    public RestBase(Integer status, String detail) {
        this.detail = detail;
        this.status = status;

    }
    public RestBase() {

    }

    public RestBase(String detail) {
        this.detail = detail;
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
