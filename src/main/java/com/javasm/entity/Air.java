package com.javasm.entity;

import java.util.Date;

public class Air {

    private Integer id;
    private String districtId;
    private String districtName;
    private String monitorTime;
    private String pm10;
    private String pm25;
    private String monitorId;
    private String monitoringStation;
    private Date lastModifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getMonitorTime() {
        return monitorTime;
    }

    public void setMonitorTime(String monitorTime) {
        this.monitorTime = monitorTime;
    }

    public String getPm10() {
        return pm10;
    }

    public void setPm10(String pm10) {
        this.pm10 = pm10;
    }

    public String getPm25() {
        return pm25;
    }

    public void setPm25(String pm25) {
        this.pm25 = pm25;
    }

    public String getMonitorId() {
        return monitorId;
    }

    public void setMonitorId(String monitorId) {
        this.monitorId = monitorId;
    }

    public String getMonitoringStation() {
        return monitoringStation;
    }

    public void setMonitoringStation(String monitoringStation) {
        this.monitoringStation = monitoringStation;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    @Override
    public String toString() {
        return "Air{" +
                "id=" + id +
                ", districtId='" + districtId + '\'' +
                ", districtName='" + districtName + '\'' +
                ", monitorTime='" + monitorTime + '\'' +
                ", pm10='" + pm10 + '\'' +
                ", pm25='" + pm25 + '\'' +
                ", monitorId='" + monitorId + '\'' +
                ", monitoringStation='" + monitoringStation + '\'' +
                ", lastModifyTime=" + lastModifyTime +
                '}';
    }
}