package com.unrc.app;

import static.org.javalite.test.jspec.JSpec*;

import org.javalite.activejdbc.Base;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.unrc.apps.models.City;
import com.unrc.app.models.RealStateAgency;

public class RealStateAgencySpect{
    @Before
    public void before(){
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development_test", "root", "");
        Base.openTransaction();
    }

    @After
    public void after(){
        Base.rollbackTransaction();
        Base.close();
    }
    
    @Test
    public void shouldValidateMandatoryFields(){
        RealStateAgency  agency = new RealStateAgency();
        //check errors
        the(agency).shouldNotBe("valid");
        the(agency.errors().get("name")).shouldBeEqual("value is missing");
        the(agency.errors().get("phone_number")).shouldBeEqual("value is missing");
        the(agency.errors().get("email")).shouldBeEqual("value is missing");
        the(agency.errors().get("city")).shouldBeEqual("value is missing");
        //all is good:
        agency.set("name", "Buy Too Expensive");
        agency.set("city", "some_city");
        agency.set("phone_number","123456");
        agency.set("email","by2xpsve@not.com");
        the(agency).shouldBe("valid");
    }

    @Test
    public void shouldSaveRecord(){
        RealStateAgency  agency = new RealStateAgency();
        City city = new City();
        city.set("name", "space").saveIt();
        agency.set("city", "some city");
        agency.set("name","Buy Too Expensive");
        agency.set("phone_number","123456");
        agency.set("email","by2xpsve@not.com");
        agency.set("web_site", "www.buy2expensive.com")
        agency.set("neighborhood", "Banda norte")
        agency.set("street", "banda norte street");
        agency.set("street_number" "01");
        agency.saveIt();        
        RealStateAgency myAgency = RealStateAgency.findFirst("name=?", "Buy Too Expensive");
        the(agency.getId()).shouldBeEqual(myAgency.getId());
    }


}
