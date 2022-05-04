package com.ssafy.happyhouse.dto;

public class Notice {
    private int noticeNo;
    private String title;
    private String body;
    private int views;
    private String userInfoId;

    public Notice() {
    }

    public Notice(int noticeNo, String title, String body, int views, String userInfoId) {
        this.noticeNo = noticeNo;
        this.title = title;
        this.body = body;
        this.views = views;
        this.userInfoId = userInfoId;
    }

    public int getNoticeNo() {
        return noticeNo;
    }

    public void setNoticeNo(int noticeNo) {
        this.noticeNo = noticeNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(String userInfoId) {
        this.userInfoId = userInfoId;
    }

    @Override
    public String toString() {
        return "notice{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", views=" + views +
                ", userInfoId='" + userInfoId + '\'' +
                '}';
    }
}
