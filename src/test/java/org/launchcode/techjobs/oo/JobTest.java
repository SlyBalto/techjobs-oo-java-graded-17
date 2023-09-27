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

//    this is the only field in Job class that is actually just a String, the rest of them are actually custom objects so we can modularly add more info. for example,
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
        Job job1 = new Job("Castle Guard", new Employer("House Atreides"), new Location("Castle Caladan"),
                new PositionType("Defense"), new CoreCompetency("Alertness"));
        Job job2 = new Job("Castle Guard", new Employer("House Atreides"), new Location("Castle Caladan"),
                new PositionType("Defense"), new CoreCompetency("Alertness"));

        assertFalse(job1.equals(job2));
    }
}
