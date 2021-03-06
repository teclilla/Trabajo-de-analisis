package com.unrc.app;

import com.unrc.app.models.Owner;

/**
 *
 **/

public class crudOwner{

    /**
     * create : create a new owner
     * @param : fist_name, last_name : The fist and the last name of the owner (respectively)
     *           email: the e-mail from de owner
     * @pre : true
     * @pos : a new owner is created, whit a firs and a last name and an email
     **/
    public void create(String first_name, String last_name, String email){
        Owner owner = new Owner();
        owner.set("first_name", first_name);
        owner.set("last_name", last_name);
        owner.set("email", email);
    }   

    /**
     * delete : delete an exisisting owner
     * @param : id: the id of the owner, if the owner does not exists the id either
     * @pre : the user must exists, otherwise the id-searching make nonsense
     * @pos: the owner of id <param>id</param> is deleted 
     **/
    public void delete(String id){
        Owner owner = Owner.findFirst("id=?", id);
        owner.deleteCascade();
    }

    /**
     * update: modify any of the fiels of any particular Owner
     * @param: the data fields of the owner to swap
     * @pre: the owner must exist
     * @pos: the owner's fields changes
     **/
    public void update(String id, String first_name, String last_name, String email){
        Owner owner =  Owner.findFirst("id=?", id);
        owner.set("first_name", first_name);
        owner.set("last_name", last_name);
        owner.set("email", email);
        owner.saveIt();   
    }


}
