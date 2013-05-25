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
        Building building = new Building();
        //check errors
        the(building).shouldNotBe("valid");
        the(building.errors().get("type")).shouldBeEqual("value is missing");
        the(building.errors().get("city")).shouldBeEqual("value is missing");
        the(building.errors().get("neighborhood")).shouldBeEqual("value is missing");
        the(building.errors().get("street")).shouldBeEqual("value is missing");
        the(building.errors().get("street_number")).shouldBeEqual("value is missing");
        the(building.errors().get("owner_id")).shouldBeEqual("value is missing");
        //all is good:
        building.set("type","garage");
        building.set("owner_id", owner.getId());
        building.set("neighborhood","some neighborhood");
        the(building).shouldBe("valid");
    }
    
   @Test
    public void shouldSaveRecord(){
        Building building = new Building();
        Owner owner = new Owner():
        owner.set("first_name","Lisa");
        owner.set("last_name","Simpson");
        owner.set("email","lisasimpson@fox.com");
        owner.saveIt();
                
        building.set("type", "land");
        building.set("owner_id", owner.getId());
        building.set("city", "some city");
        building.set("neighborhood", "some neighborhood");
        building.set("street", "");
        building.set("street_number", 22 );
        building.set("description", "Great building!");
        buiding.set("price", "200000");
        buidlng.set("operation", "venta");
        building.saveIt();

        Building b = Building.findFirst("owner_id = ?", owner.getId());
        the(building.getId()).shouldBeEqual(b.getId());
    }
}

