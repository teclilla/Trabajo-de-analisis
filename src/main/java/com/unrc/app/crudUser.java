package com.unrc.app;

import com.unrc.app.models.Owner;

public class crudUser{

    /**
     * create : create a new user
     * @param : fist_name, last_name : The fist and the last name of the user (respectively)
     *           email: the e-mail from de user 
     * @pre : true
     * @pos : a new user is created, whit a firs and a last name and an email
     **/
    public void create(String first_name, String last_name, String email){
        Owner owner = new Owner();
        owner.set("first_name", first_name);
        owner.set("last_name", last_name);
    }   

    /**
     * delete : delete an exisisting owner
     * @param : id: the id of the user, if the user does not exists the id either
     * @pre : the user must exists, otherwise the id-searching make nonsense
     * @pos: the user of id <param>id</param> is deleted 
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
    public void update(String id, String first_name, String last_name){
        User user =  User.findFirst("id=?", id);
        user.set("first_name", first_name);
        user.set("last_name", last_name);
        user.saveIt();   
    }


}
