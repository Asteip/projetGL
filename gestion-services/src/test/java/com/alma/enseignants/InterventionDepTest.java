package com.alma.enseignants;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class InterventionDepTest extends TestCase{
	private InterventionDep inter;
	private Service serv = new Service(10, 2015);

	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public InterventionDepTest( String testName )
	{
		super( testName );
	}

	protected void setUp() throws Exception {
		super.setUp();
		inter = new InterventionDep(10,serv,10);
	}
	protected void tearDown() throws Exception {
		super.tearDown();
		inter = null;
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite()
	{
		return new TestSuite( InterventionDepTest.class );
	}

	public void testInterventionDep() {
		assertNotNull("L'instance n'est pas cr��e", inter);
	}
}
