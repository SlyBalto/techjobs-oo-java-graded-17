package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Employer extends JobField{
    //    Converted Employer because all of its fields and methods are included in Job Field.
    //    This design works because the tests are still passing!
    public Employer(String value) {
        super (value);
    }
    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
