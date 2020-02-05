package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


    public Job(){
        id = nextId;
        nextId++;
    }

    public Job(String name,Employer employer,Location location,PositionType positionType,CoreCompetency coreCompetency){
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;


    }

    private String getFieldValue(String input){
        return (input == null || input.isEmpty()) ? "Data not available"
                : input;
    }

    @Override
    public String toString(){
        String newLine = "\n";
        String id = "ID: " + getFieldValue(Integer.toString(getId()));
        String newName = "Name: " + getFieldValue(getName());
        String newEmployer = "Employer: " + getFieldValue(getEmployer().toString());
        String newLocation = "Location: " + getFieldValue(getLocation().toString());
        String newPositionType = "Position Type: " + getFieldValue(getPositionType().toString());
        String newCoreCompetency = "Core Competency: " + getFieldValue(getCoreCompetency().toString());
        String output = newLine +
                        id + newLine +
                        newName + newLine +
                        newEmployer + newLine +
                        newLocation + newLine +
                        newPositionType + newLine +
                        newCoreCompetency + newLine;
        return output;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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

    public int getId() {
        return id;
    }
}
