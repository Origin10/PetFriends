package com.bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MemShipping {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String memShippingName;
    private String memShippingStreet1;
    private String memShippingStreet2;
    private String memShippingCity;
    private String memShippingState;
    private String memShippingCountry;
    private String memShippingZipcode;
    private boolean memShippingDefault;


    @ManyToOne
    @JoinColumn(name = "mem_id")
    private Mem mem;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getMemShippingName() {
        return memShippingName;
    }


    public void setMemShippingName(String memShippingName) {
        this.memShippingName = memShippingName;
    }


    public String getMemShippingStreet1() {
        return memShippingStreet1;
    }


    public void setMemShippingStreet1(String memShippingStreet1) {
        this.memShippingStreet1 = memShippingStreet1;
    }


    public String getMemShippingStreet2() {
        return memShippingStreet2;
    }


    public void setMemShippingStreet2(String memShippingStreet2) {
        this.memShippingStreet2 = memShippingStreet2;
    }


    public String getMemShippingCity() {
        return memShippingCity;
    }


    public void setMemShippingCity(String memShippingCity) {
        this.memShippingCity = memShippingCity;
    }


    public String getMemShippingState() {
        return memShippingState;
    }


    public void setMemShippingState(String memShippingState) {
        this.memShippingState = memShippingState;
    }


    public String getMemShippingCountry() {
        return memShippingCountry;
    }


    public void setMemShippingCountry(String memShippingCountry) {
        this.memShippingCountry = memShippingCountry;
    }


    public String getMemShippingZipcode() {
        return memShippingZipcode;
    }


    public void setMemShippingZipcode(String memShippingZipcode) {
        this.memShippingZipcode = memShippingZipcode;
    }


    public Mem getMem() {
        return mem;
    }


    public void setMem(Mem mem) {
        this.mem = mem;
    }


    public boolean isMemShippingDefault() {
        return memShippingDefault;
    }


    public void setMemShippingDefault(boolean memShippingDefault) {
        this.memShippingDefault = memShippingDefault;
    }


}
