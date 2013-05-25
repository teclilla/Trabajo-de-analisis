package com.unrc.app;

import static org.javalite.test.jspec.JSpec.*;

import org.javalite.activejdbc.Base;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.unrc.app.models.City;
import com.unrc.app.models.Owner;

public class OwnerSpec {
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
        Owner owner = new Owner();
        //check errors
        the(owner).shouldNotBe("valid");
        the(owner.errors().get("first_name")).shouldBeEqual("Name");
        the(owner.errors().get("last_name")).shouldBeEqual("LastName");
        the(owner.errors().get("email")).shouldBeEqual("Email");
        //all is good:
        owner.set("first_name","Homer");
        owner.set("last_name","Simpson");
        owner.set("email","homersimpson@fox.com");
        the(owner).shouldBe("valid");
    }
    
   @Test
    public void shouldSaveRecord(){
        Owner owner = new Owner();
        owner.set("first_name","Lisa");
        owner.set("last_name","Simpson");
        owner.set("email","lisasimpson@fox.com");
        owner.saveIt();
        Owner o = Owner.findFirst("first_name = ?", "Homer");
        the(owner.getId()).shouldBeEqual(o.getId());
    }
}



