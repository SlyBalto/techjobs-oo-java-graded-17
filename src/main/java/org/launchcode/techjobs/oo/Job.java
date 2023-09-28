package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
//    Really cool how we have the following fields as their own objects instead of just being strings.
//    making things way more modular, honestly kinda blew my mind!
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
//
    public Job(){
        id = nextId;
        nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
//      calls first constructor, so we can use the 'id' field
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return id;
    }
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    public String toString() {
        return System.lineSeparator() + // Starts with blank line
                "ID: " + this.getId() + System.lineSeparator() +
//                name is a String while Employer and others are actually objects so we need to use their getValue methods we made.
                "Name: " + (this.getName() == null || this.getName().isEmpty() ? "Data not available" : this.getName()) + System.lineSeparator() +
                "Employer: " + (this.getEmployer().getValue() == null || this.getEmployer().getValue().isEmpty() ? "Data not available" : this.getEmployer().getValue()) + System.lineSeparator() +
                "Location: " + (this.getLocation().getValue() == null || this.getLocation().getValue().isEmpty() ? "Data not available" : this.getLocation().getValue()) + System.lineSeparator() +
                "Position Type: " + (this.getPositionType().getValue() == null || this.getPositionType().getValue().isEmpty() ? "Data not available" : this.getPositionType().getValue()) + System.lineSeparator() +
                "Core Competency: " + (this.getCoreCompetency().getValue() == null || this.getCoreCompetency().getValue().isEmpty() ? "Data not available" : this.getCoreCompetency().getValue()) + System.lineSeparator();// Ends with blank line
    }

} //end of public class Job
