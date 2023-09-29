package org.launchcode.techjobs.oo;

import java.util.Objects;

public  class CoreCompetency extends JobField {
    //    Converted CoreCompetency because all of its fields and methods are included in Job Field.
    public CoreCompetency(String value) {
        super (value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
