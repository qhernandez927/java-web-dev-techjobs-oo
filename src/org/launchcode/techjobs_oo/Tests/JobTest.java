package org.launchcode.techjobs_oo.Tests;

import org.junit.After;
import org.junit.Test;
import org.launchcode.techjobs_oo.Employer;
import org.launchcode.techjobs_oo.Job;
import org.junit.Before;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.launchcode.techjobs_oo.*;


public class JobTest {









    @Test
    public void testSettingJobId(){
        Job jobOne = new Job();
        Job jobTwo = new Job();
        assertFalse(jobOne.equals(jobTwo));
        assertTrue((jobTwo.getId()-jobOne.getId())== 1);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job jobUnderTest = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(jobUnderTest instanceof Job);
        System.out.println("THis is ID:" + jobUnderTest.getId());
        assertTrue(jobUnderTest.getId()>-1);
        assertTrue(jobUnderTest.getName()=="Product tester");
        assertTrue(jobUnderTest.getEmployer().toString()=="ACME");
        assertTrue(jobUnderTest.getLocation().toString()=="Desert");
        assertTrue(jobUnderTest.getPositionType().toString()=="Quality control");
        assertTrue(jobUnderTest.getCoreCompetency().toString()=="Persistence");
    }

    @Test
    public void testJobsForEquality(){
        Job jobUnderTest = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job jobUnderTestTwo = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(jobUnderTest.equals(jobUnderTestTwo));
    }

    @Test
    public void testToStringMethod(){
         Job jobUnderTest = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
         String output = jobUnderTest.toString();
         int indexOfFirstNewLine = output.indexOf('\n');
         int indexOfLastNewLine = output.lastIndexOf('\n');
         int indexOfLastChar = output.length() - 1;
         int jobID = jobUnderTest.getId();
         assertTrue(output.contains("ID: "+jobID+"\n"));
         assertTrue(output.contains("Name: Product tester\n"));
         assertTrue(output.contains("Employer: ACME\n"));
         assertTrue(output.contains("Location: Desert\n"));
         assertTrue(output.contains("Position Type: Quality control\n"));
         assertTrue(output.contains("Core Competency: Persistence\n"));
         assertTrue(indexOfFirstNewLine == 0);
         assertTrue(indexOfLastNewLine == indexOfLastChar);

    }

    @Test
    public void testToStringMethodHandlesEmptyField(){
        Job jobUnderTest = new Job("", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String output = jobUnderTest.toString();
        int indexOfFirstNewLine = output.indexOf('\n');
        int indexOfLastNewLine = output.lastIndexOf('\n');
        int indexOfLastChar = output.length() - 1;
        int jobID = jobUnderTest.getId();
        assertTrue(output.contains("ID: "+jobID+"\n"));
        assertTrue(output.contains("Name: Data not available\n"));
        assertTrue(output.contains("Employer: ACME\n"));
        assertTrue(output.contains("Location: Desert\n"));
        assertTrue(output.contains("Position Type: Quality control\n"));
        assertTrue(output.contains("Core Competency: Persistence\n"));
        assertTrue(indexOfFirstNewLine == 0);
        assertTrue(indexOfLastNewLine == indexOfLastChar);

    }

    @Test
    public void testToStringMethodHandlesAllEmptyFields(){
        Job jobUnderTest = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        String output = jobUnderTest.toString();
        int indexOfFirstNewLine = output.indexOf('\n');
        int indexOfLastNewLine = output.lastIndexOf('\n');
        int indexOfLastChar = output.length() - 1;
        int jobID = jobUnderTest.getId();
        assertTrue(output.contains("ID: "+jobID+"\n"));
        assertTrue(output.contains("Name: Data not available\n"));
        assertTrue(output.contains("Employer: Data not available\n"));
        assertTrue(output.contains("Location: Data not available\n"));
        assertTrue(output.contains("Position Type: Data not available\n"));
        assertTrue(output.contains("Core Competency: Data not available\n"));
        assertTrue(indexOfFirstNewLine == 0);
        assertTrue(indexOfLastNewLine == indexOfLastChar);

    }

}
