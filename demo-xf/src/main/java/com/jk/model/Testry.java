package com.jk.model;

import java.io.Serializable;

public class Testry implements Serializable {
    private static final long serialVersionUID = 4722950574096059555L;
    private Integer testid;

    private String testname;

    private String testiphone;

    private Integer testsex;

    public Integer getTestid() {
        return testid;
    }

    public void setTestid(Integer testid) {
        this.testid = testid;
    }

    public String getTestname() {
        return testname;
    }

    public void setTestname(String testname) {
        this.testname = testname == null ? null : testname.trim();
    }

    public String getTestiphone() {
        return testiphone;
    }

    public void setTestiphone(String testiphone) {
        this.testiphone = testiphone == null ? null : testiphone.trim();
    }

    public Integer getTestsex() {
        return testsex;
    }

    public void setTestsex(Integer testsex) {
        this.testsex = testsex;
    }
}