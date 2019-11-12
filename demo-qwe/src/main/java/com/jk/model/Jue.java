package com.jk.model;

import java.io.Serializable;

public class Jue implements Serializable {
    private Integer rid;

    private String rname;
    
    private String uzt;
    
    

    public String getUzt() {
		return uzt;
	}

	public void setUzt(String uzt) {
		this.uzt = uzt;
	}

	public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname == null ? null : rname.trim();
    }
}