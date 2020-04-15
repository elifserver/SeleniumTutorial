import org.junit.*;


public class AnnotationExample {
    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Before class working....");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Before test working....");
    }

    @Test
    public void test1() {
        // System.out.println("Test1 method working....");
        System.out.println("Test1 method working....");

    }

    @Test
    public void test2() {
        System.out.println("Test2 method working....");
        //Assert.assertTrue(false);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("After test working....");

    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("After class working....");
    }
}
