package com.Model;

/**
 * Created by andrewjin on 2018/6/19.
 */

public class Room {

    /**
     * roomId : 1
     * publishTime : 3333
     * location : 2222
     * rentWay : 111
     * subject : 1
     * rtx : derry
     * money : 3211
     * deadline : 2131
     * description : heklo
     */

    private int roomId;
    private int publishTime;
    private String location;
    private int rentWay;
    private int subject;
    private String rtx;
    private int money;
    private int deadline;
    private String description;

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(int publishTime) {
        this.publishTime = publishTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getRentWay() {
        return rentWay;
    }

    public void setRentWay(int rentWay) {
        this.rentWay = rentWay;
    }

    public int getSubject() {
        return subject;
    }

    public void setSubject(int subject) {
        this.subject = subject;
    }

    public String getRtx() {
        return rtx;
    }

    public void setRtx(String rtx) {
        this.rtx = rtx;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
