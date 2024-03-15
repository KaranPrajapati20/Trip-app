package com.example.tripapp;

public class Model {
    String AMOBILE;
    String COMING_DATE;
    String EMAIL;
    String LIVING_DATE;
    String MEMBER;
    String MOBILE;
    String MONEY;
    String NAME;
    String SPINNER;

    public Model() {}

    public Model(String AMOBILE, String COMING_DATE, String EMAIL, String LIVING_DATE, String MEMBER, String MOBILE, String MONEY, String NAME, String SPINNER) {
        this.AMOBILE = AMOBILE;
        this.COMING_DATE = COMING_DATE;
        this.EMAIL = EMAIL;
        this.LIVING_DATE = LIVING_DATE;
        this.MEMBER = MEMBER;
        this.MOBILE = MOBILE;
        this.MONEY = MONEY;
        this.NAME = NAME;
        this.SPINNER = SPINNER;
    }

    public String getAMOBILE() {
        return AMOBILE;
    }

    public void setAMOBILE(String AMOBILE) {
        this.AMOBILE = AMOBILE;
    }

    public String getCOMING_DATE() {
        return COMING_DATE;
    }

    public void setCOMING_DATE(String COMING_DATE) {
        this.COMING_DATE = COMING_DATE;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getLIVING_DATE() {
        return LIVING_DATE;
    }

    public void setLIVING_DATE(String LIVING_DATE) {
        this.LIVING_DATE = LIVING_DATE;
    }

    public String getMEMBER() {
        return MEMBER;
    }

    public void setMEMBER(String MEMBER) {
        this.MEMBER = MEMBER;
    }

    public String getMOBILE() {
        return MOBILE;
    }

    public void setMOBILE(String MOBILE) {
        this.MOBILE = MOBILE;
    }

    public String getMONEY() {
        return MONEY;
    }

    public void setMONEY(String MONEY) {
        this.MONEY = MONEY;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getSPINNER() {
        return SPINNER;
    }

    public void setSPINNER(String SPINNER) {
        this.SPINNER = SPINNER;
    }
}
