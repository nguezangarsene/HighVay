package com.cs425.mpweb.model;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.List;

//Unideirectional solution
@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sup_id;
    private String name;
    private String contactPhoneNumber;

    public Supplier() {
    }

    public Supplier(String name) {
        this.name = name;
    }

    public int getSup_id() {
        return sup_id;
    }

    public void setSup_id(int sup_id) {
        this.sup_id = sup_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString(){
        return "[name="+name+"]";
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }
}
