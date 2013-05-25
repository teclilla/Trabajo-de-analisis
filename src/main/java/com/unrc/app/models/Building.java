package com.unrc.app.models;

import org.javalite.activejdbc.Model;

public class Building extends Model {
  static{
      validatePresenceOf("type", "owner_id", "city", "neighborhood", "street", "street_number", "operation");
  }
}
