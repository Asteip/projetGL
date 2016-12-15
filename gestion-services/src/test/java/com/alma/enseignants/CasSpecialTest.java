package com.alma.enseignants;

import junit.framework.*;

/**
 * Unit test for CasSpecial.
 */
public class CasSpecialTest extends TestCase{
	private CasSpecial casSpe;
	private Service serv = new Service(10, 2015);

	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public CasSpecialTest( String testName )
	{
		super( testName );
	}

	protected void setUp() throws Exception {
		super.setUp();
		casSpe = new CasSpecial(10,serv);
	}
	protected void tearDown() throws Exception {
		super.tearDown();
		casSpe = null;
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite()
	{
		return new TestSuite( CasSpecialTest.class );
	}

	public void testCasSpecial() {
		assertNotNull("L'instance n'est pas créée", casSpe);
	}

}
