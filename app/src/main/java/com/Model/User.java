package com.Model;

import java.io.Serializable;

/**
 * Created by andrewjin on 2018/6/21.
 */

public class User{
    private Integer userId;
    private String rtx;
    private String outlookPwd;
    private String icon;

    public User() {
    }

    public User(String rtx, String outlookPwd, String icon) {
        this.rtx = rtx;
        this.outlookPwd = outlookPwd;
        this.icon = icon;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRtx() {
        return rtx;
    }

    public void setRtx(String rtx) {
        this.rtx = rtx;
    }

    public String getOutlookPwd() {
        return outlookPwd;
    }

    public void setOutlookPwd(String outlookPwd) {
        this.outlookPwd = outlookPwd;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
