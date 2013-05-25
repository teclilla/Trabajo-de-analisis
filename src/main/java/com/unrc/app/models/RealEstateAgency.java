package com.unrc.app.models;

import org.javalite.activejdbc.Model;

public class RealEstateAgency.java extends Model{
    static{
        validatePresenceOf("name", "email","phone_number", "city");
    }
}
