package org.launchcode.techjobs.oo;

import org.junit.Test;

import java.lang.reflect.Method;
//intelliJ wanted me to use this instead, I'm guessing this auto-imports all asserts we need.
import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();

        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job jobTest = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

//    this is the only field in Job class that is actually just a String, the rest of them are actually modular objects, so we can add more info. for example,
//        we can add extra info for a location. what if we want to add more categories that only fit under "location", etc.?
        assertTrue(jobTest.getName() instanceof String);
        assertEquals("Product tester", jobTest.getName());

        assertTrue(jobTest.getEmployer() instanceof Employer);
        assertEquals("ACME", jobTest.getEmployer().getValue());

        assertTrue(jobTest.getLocation() instanceof Location);
        assertEquals("Desert", jobTest.getLocation().getValue());

        assertTrue(jobTest.getPositionType() instanceof PositionType);
        assertEquals("Quality control", jobTest.getPositionType().getValue());

        assertTrue(jobTest.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", jobTest.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
//        if job3 had an id of 0, then job4's id should be 1, because the class automatically updates what should be the next id.
        Job job3 = new Job("Castle Guard", new Employer("House Atreides"), new Location("Castle Caladan"),
                new PositionType("Defense"), new CoreCompetency("Alertness"));
        Job job4 = new Job("Castle Guard", new Employer("House Atreides"), new Location("Castle Caladan"),
                new PositionType("Defense"), new CoreCompetency("Alertness"));

        assertFalse(job3.equals(job4));
    }

    //    show ids to TA, not sure why the numbers have to be in this weird order, double check this is okay
    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job5 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String expectedFormat1 = System.lineSeparator() + // Starts with blank line
                "ID: 5" + System.lineSeparator() +
                "Name: Product tester" + System.lineSeparator() +
                "Employer: ACME" + System.lineSeparator() +
                "Location: Desert" + System.lineSeparator() +
                "Position Type: Quality control" + System.lineSeparator() +
                "Core Competency: Persistence" + System.lineSeparator();// Ends with blank line
        String jobString1 = job5.toString();
        assertEquals(expectedFormat1, jobString1);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job6 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String expectedFormat2 = System.lineSeparator() +
                "ID: 4" + System.lineSeparator() +
                "Name: Product tester" + System.lineSeparator() +
                "Employer: ACME" + System.lineSeparator() +
                "Location: Desert" + System.lineSeparator() +
                "Position Type: Quality control" + System.lineSeparator() +
                "Core Competency: Persistence" + System.lineSeparator();
        String jobString2 = job6.toString();
        assertEquals(expectedFormat2, jobString2);
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job7 = new Job("Web Developer", new Employer(""), new Location("StL"),
                new PositionType(""), new CoreCompetency("Java"));
        String expectedFormat3 = String.format( System.lineSeparator() +
                "ID: 3" + System.lineSeparator() +
                "Name: Web Developer" + System.lineSeparator() +
                "Employer: Data not available" + System.lineSeparator() +
                "Location: StL" + System.lineSeparator() +
                "Position Type: Data not available" + System.lineSeparator() +
                "Core Competency: Java" + System.lineSeparator(), job7.getId(), job7.getName(), job7.getLocation(), job7.getCoreCompetency());
        String jobString3 = job7.toString();
        assertEquals(expectedFormat3, jobString3);
    }
}