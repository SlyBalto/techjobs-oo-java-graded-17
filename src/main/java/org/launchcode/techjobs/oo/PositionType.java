package org.launchcode.techjobs.oo;

import java.util.Objects;

public  class PositionType extends JobField {
    //    Converted PositionType because all of its fields and methods are included in Job Field.
    public PositionType(String value) {
        super (value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
