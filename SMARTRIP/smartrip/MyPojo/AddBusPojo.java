package com.grv.vikash.smartrip.MyPojo;

/**
 * Created by vikash on 12-07-2017.
 */

public class AddBusPojo {
    int id;
    String busAgency, busType, busSource, busDestination, busStartTime,
    busEndTime, totalBusTime, busSeat, busFare;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBusAgency() {
        return busAgency;
    }

    public void setBusAgency(String busAgency) {
        this.busAgency = busAgency;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    public String getBusSource() {
        return busSource;
    }

    public void setBusSource(String busSource) {
        this.busSource = busSource;
    }

    public String getBusDestination() {
        return busDestination;
    }

    public void setBusDestination(String busDestination) {
        this.busDestination = busDestination;
    }

    public String getBusStartTime() {
        return busStartTime;
    }

    public void setBusStartTime(String busStartTime) {
        this.busStartTime = busStartTime;
    }

    public String getBusEndTime() {
        return busEndTime;
    }

    public void setBusEndTime(String busEndTime) {
        this.busEndTime = busEndTime;
    }

    public String getTotalBusTime() {
        return totalBusTime;
    }

    public void setTotalBusTime(String totalBusTime) {
        this.totalBusTime = totalBusTime;
    }

    public String getBusSeat() {
        return busSeat;
    }

    public void setBusSeat(String busSeat) {
        this.busSeat = busSeat;
    }

    public String getBusFare() {
        return busFare;
    }

    public void setBusFare(String busFare) {
        this.busFare = busFare;
    }

    @Override
    public String toString() {
        return "AddBusPojo{" +
                "id=" + id +
                ", busAgency='" + busAgency + '\'' +
                ", busType='" + busType + '\'' +
                ", busSource='" + busSource + '\'' +
                ", busDestination='" + busDestination + '\'' +
                ", busStartTime='" + busStartTime + '\'' +
                ", busEndTime='" + busEndTime + '\'' +
                ", totalBusTime='" + totalBusTime + '\'' +
                ", busSeat='" + busSeat + '\'' +
                ", busFare='" + busFare + '\'' +
                '}';
    }
}
