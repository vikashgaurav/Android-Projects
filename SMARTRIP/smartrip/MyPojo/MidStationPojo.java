package com.grv.vikash.smartrip.MyPojo;

/**
 * Created by vikash on 06-07-2017.
 */

public class MidStationPojo {
    String trainNO, msName, msDistance, msTime;

    public String getTrainNO() {
        return trainNO;
    }

    public void setTrainNO(String trainNO) {
        this.trainNO = trainNO;
    }

    public String getMsName() {
        return msName;
    }

    public void setMsName(String msName) {
        this.msName = msName;
    }

    public String getMsDistance() {
        return msDistance;
    }

    public void setMsDistance(String msDistance) {
        this.msDistance = msDistance;
    }

    public String getMsTime() {
        return msTime;
    }

    public void setMsTime(String msTime) {
        this.msTime = msTime;
    }

    @Override
    public String toString() {
        return "MidStationPojo{" +
                "trainNO='" + trainNO + '\'' +
                ", msName='" + msName + '\'' +
                ", msDistance='" + msDistance + '\'' +
                ", msTime='" + msTime + '\'' +
                '}';
    }
}
