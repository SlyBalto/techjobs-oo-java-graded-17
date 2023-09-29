package org.launchcode.techjobs.oo;

import java.util.Objects;

public  class Location extends JobField {
//    Converted Location because all of its fields and methods are included in Job Field.
    public Location(String value) {
        super (value);
    }

//    was not sure if hashcode needed to be included or not. I read it's helpful to have a unique hashcode method
//    for each
    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
