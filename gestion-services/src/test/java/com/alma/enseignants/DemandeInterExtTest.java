package com.alma.enseignants;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class DemandeInterExtTest extends TestCase{
	private DemandeInterExt demande;
	private Service serv = new Service(10, 2015);

	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public DemandeInterExtTest( String testName )
	{
		super( testName );
	}

	protected void setUp() throws Exception {
		super.setUp();
	//	demande = new DemandeInterExt(10,new Enseignant(nom, prenom, status, departement, contrat, id));
	}
	protected void tearDown() throws Exception {
		super.tearDown();
		demande = null;
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite()
	{
		return new TestSuite( CasSpecialTest.class );
	}

	public void testCasSpecial() {
		assertNotNull("L'instance n'est pas créée", demande);
	}
}
