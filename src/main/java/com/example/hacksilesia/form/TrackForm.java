package com.example.hacksilesia.form;

import javax.validation.constraints.NotNull;

public class TrackForm {

    @NotNull
    private String name;
    @NotNull
    private Double start_latitude;
    @NotNull
    private Double start_longitude;
    @NotNull
    private Double end_latitude;
    @NotNull
    private Double end_longitude;
    @NotNull
    private Integer space;
    @NotNull
    private String telephone;
    @NotNull
    private String time;
    private String other;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getStart_latitude() {
        return start_latitude;
    }

    public void setStart_latitude(Double start_latitude) {
        this.start_latitude = start_latitude;
    }

    public Double getStart_longitude() {
        return start_longitude;
    }

    public void setStart_longitude(Double start_longitude) {
        this.start_longitude = start_longitude;
    }

    public Double getEnd_latitude() {
        return end_latitude;
    }

    public void setEnd_latitude(Double end_latitude) {
        this.end_latitude = end_latitude;
    }

    public Double getEnd_longitude() {
        return end_longitude;
    }

    public void setEnd_longitude(Double end_longitude) {
        this.end_longitude = end_longitude;
    }

    public Integer getSpace() {
        return space;
    }

    public void setSpace(Integer space) {
        this.space = space;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
