package com.alma.enseignants;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class InterventionExtTest extends TestCase{
	private InterventionExt inter;
	private Service serv = new Service(10, 2015);

	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public InterventionExtTest( String testName )
	{
		super( testName );
	}

	protected void setUp() throws Exception {
		super.setUp();
		inter = new InterventionExt(10,serv);
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
		return new TestSuite( InterventionExtTest.class );
	}

	public void testInterventionExt() {
		assertNotNull("L'instance n'est pas créée", inter);
	}
}
