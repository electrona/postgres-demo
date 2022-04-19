package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "store_info_tb")
public class Store extends StoreAudit {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String identification;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private int phone;
    private String email;
}
