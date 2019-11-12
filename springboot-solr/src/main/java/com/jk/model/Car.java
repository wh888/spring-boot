package com.jk.model;

import java.io.Serializable;
import java.util.Date;

public class Car implements Serializable {
    private static final long serialVersionUID = 4028327645706513544L;
    private Integer carid;

    private String carname;

    private String cartime;

    private Integer carsl;

    private Integer carlx;

    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname == null ? null : carname.trim();
    }

    public String getCartime() {
        return cartime;
    }

    public void setCartime(String cartime) {
        this.cartime = cartime;
    }

    public Integer getCarsl() {
        return carsl;
    }

    public void setCarsl(Integer carsl) {
        this.carsl = carsl;
    }

    public Integer getCarlx() {
        return carlx;
    }

    public void setCarlx(Integer carlx) {
        this.carlx = carlx;
    }
}