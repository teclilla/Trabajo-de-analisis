package com.unrc.app;

import com.unrc.app.models.Owner;

/**
 *
 **/

public class crudBuilding{

    /**
     * create : create a new building
     * @param : 
     * @pre : true
     * @pos : a new building is created 
     **/
    public void create(String type, String descryption, String operation, float price, int owner_id,
                        String city, String street, int street_number )
    {
        Building building = new Building();
        building.set("type", type);
        building.set("description", description);
        building.set("operation", operation);
        building.set("price", price);
        building.set("owner_id", owner_id);
        building.set("city", city);
        building.set("street", street);
        building.set("street_number", street_number);
        building.saveIt();        
    }   

    /**
     * delete : delete an exisisting building
     * @param : id: the id of the building
     * @pre : the building exists
     * @pos: the building is deleted
     **/
    public void delete(String id){
        Building building = Building.findFirst("id=?", id);
        building.deleteCascade();
    }

    /**
     * update: modify any of the fiels of any particular Building
     * @param: the data fields of the Building to swap
     * @pre: the building must exist
     * @pos: the building's fields changes
     **/
    public void update(String id,  first_name, String last_name, String email){
        Building building = Building.findFirst("id=?", id);
        building.set("type", type);
        building.set("description", description);
        building.set("operation", operation);
        building.set("price", price);
        building.set("owner_id", owner_id);
        building.set("city", city);
        building.set("street", street);
        building.set("street_number", street_number);
        building.saveIt();  
    }


}
