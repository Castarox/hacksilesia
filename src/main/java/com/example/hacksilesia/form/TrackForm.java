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
}
