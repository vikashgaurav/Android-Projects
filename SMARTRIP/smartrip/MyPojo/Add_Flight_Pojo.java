package com.grv.vikash.smartrip.MyPojo;

/**
 * Created by vikash on 03-07-2017.
 */

public class Add_Flight_Pojo {
    int id;
    String flight, no, source, destination, startTime, endTime, sun, mon, tue, wed, thu, fri, sat, fare ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
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

    public String getFare() {
        return fare;
    }

    public void setFare(String fare) {
        this.fare = fare;
    }

    @Override
    public String toString() {
        return "Add_Flight_Pojo{" +
                "id=" + id +
                ", flight='" + flight + '\'' +
                ", no='" + no + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", sun='" + sun + '\'' +
                ", mon='" + mon + '\'' +
                ", tue='" + tue + '\'' +
                ", wed='" + wed + '\'' +
                ", thu='" + thu + '\'' +
                ", fri='" + fri + '\'' +
                ", sat='" + sat + '\'' +
                ", fare='" + fare + '\'' +
                '}';
    }
}
