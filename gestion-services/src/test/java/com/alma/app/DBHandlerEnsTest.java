import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class DBHandlerEnsTest {

	private DBHandlerEns instance;

	 @Before
	    public void setUp() throws Exception {
		 instance = DBHandlerEns.getInstance();
		 instance.openDB();
	}

	@Test
	public void testGetInstance() {
	      assertTrue(instance != null);
	}

  //test sur recup
	@Test
	public void testRetrieve() {
		Map<String, String> m= DBHandlerEns.getInstance().retrieve(1);
		assertTrue(m.get("price").equals("7.0"));
		assertTrue(m.get("nb_prod").equals("7"));
	}


  //test sur la création
	@Test
	public void testCreate() {
		DBHandlerEns.getInstance().create("test", "description",(float) 12.3,17,29);
		Map<String, String> m=DBHandlerEns.getInstance().retrieve(17);
		assertTrue(m.get("name").equals("test"));
		assertTrue(m.get("price").equals("12.3"));
		assertTrue(m.get("id").equals("17"));
		assertTrue(m.get("nb_prod").equals("29"));
		DBHandlerEns.getInstance().delete(17);
	}

	//test sur la recup detoute la liste
	@Test
	public void testRetrieveAll() {
		List<Map<String, String>> m= DBHandlerEns.getInstance().retrieveAll();
		System.out.println(m);
	}
}
