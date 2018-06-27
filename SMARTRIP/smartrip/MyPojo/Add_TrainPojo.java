package com.grv.vikash.smartrip.MyPojo;

/**
 * Created by vikash on 01-07-2017.
 */

public class Add_TrainPojo {

    String no, name, sun, mon, tue, wed, thu, fri, sat,source, destination,
            start, totalTime, totalkms;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSun() {
        return sun;
    }

    public void setSun(String sun) {
        this.sun = sun;
    }

    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public String getTue() {
        return tue;
    }

    public void setTue(String tue) {
        this.tue = tue;
    }

    public String getWed() {
        return wed;
    }

    public void setWed(String wed) {
        this.wed = wed;
    }

    public String getThu() {
        return thu;
    }

    public void setThu(String thu) {
        this.thu = thu;
    }

    public String getFri() {
        return fri;
    }

    public void setFri(String fri) {
        this.fri = fri;
    }

    public String getSat() {
        return sat;
    }

    public void setSat(String sat) {
        this.sat = sat;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public String getTotalkms() {
        return totalkms;
    }

    public void setTotalkms(String totalkms) {
        this.totalkms = totalkms;
    }

    @Override
    public String toString() {
        return "Add_TrainPojo{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", sun='" + sun + '\'' +
                ", mon='" + mon + '\'' +
                ", tue='" + tue + '\'' +
                ", wed='" + wed + '\'' +
                ", thu='" + thu + '\'' +
                ", fri='" + fri + '\'' +
                ", sat='" + sat + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", start='" + start + '\'' +
                ", totalTime='" + totalTime + '\'' +
                ", totalkms='" + totalkms + '\'' +
                '}';
    }
}
