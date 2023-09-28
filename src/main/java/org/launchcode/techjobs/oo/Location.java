package org.launchcode.techjobs.oo;

import java.util.Objects;

public  class Location extends JobField {
//    Converted Location because all of its fields and methods are included in Job Field.
    public Location(String value) {
        super (value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
