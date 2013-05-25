package com.unrc.app;

import com.unrc.app.models.RealStateAgency;
import java.util.List;

public class crudRealStateAgency{

    /**
     * create: create a new real state agency
     * @param: name, phone_number, email, web_site: of the agency,
     *         city, street, neighborhood, street_number: the adress of the agency
     * @pre: true
     * @pos: creates a new agency
     **/

    public static void create(String name, Integer phone_number, String email,
                    String city, String web_site, String street, String neighborhood,
                    Interger street_number)
    {
        RealStateAgency  agency = new RealStateAgency();
        agency.set("name", name);
        agency.set("phone_number", phone_number);
        agency.set("email", email);
        agency.set("city", city);
        agency.set("neighborhood", neighborhood);
        agency.set("street", street);
        agency.set("street_number", street_number);
        agency.saveIt();
    }

    /**
     * delete: delete a real state agency
     * @param: id: the id of the agency
     * @pre: the agency must exists
     * @pos: the agency is deleted
     **/    
    public static void delete(String id){
        RealStateAgency agency = findFirst("id=?", id);
        agency.deleteCascade();
    }

    /**
     * update: modify any of the fiels of any particular Owner
     * @param: the data fields of the owner to swap
     * @pre: the owner must exist
     * @pos: the owner's fields changes
     **/
    public static void update(String id, String email, String phone_number, String street, 
                                Int phone_number, String neighborhood){
        List<RealStateAgency> agencyList = RealStateAgency.find("id =?" id);
        RealStateAgency agency = list.get(0);
        agency.set("email", email);
        agency.set("phone_number", phone_number);
        agency.set("street", street);
        agency.set("street_number", street_number);
        agency.set("neighborhood", neighborhood);
        agency.saveIt();
    }
}
