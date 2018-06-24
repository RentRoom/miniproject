package com.Model;

/**
 * Created by andrewjin on 2018/6/24.
 */

public class Message {


    /**
     * id : 2
     * fromRtx : "from"
     * toRtx : "to"
     * msg : "this si test"
     * timestamp : 1529821413847
     */

    private int id;
    private String fromRtx;
    private String toRtx;
    private String msg;
    private long timestamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFromRtx() {
        return fromRtx;
    }

    public void setFromRtx(String fromRtx) {
        this.fromRtx = fromRtx;
    }

    public String getToRtx() {
        return toRtx;
    }

    public void setToRtx(String toRtx) {
        this.toRtx = toRtx;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
