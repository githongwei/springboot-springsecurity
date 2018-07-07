package com.pack.util;

/**
 * 客户端信息
 */
public class Msg {

    private String title;
    private String content;
    private String extraInfo;
    private Integer state;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Msg(String title, String content, String extraInfo) {
        this.title = title;
        this.content = content;
        this.extraInfo = extraInfo;
    }

    public Msg(String content,String extraInfo,Integer state){
        this.content = content;
        this.extraInfo = extraInfo;
        this.state = state;
    }

}
