package com.tranquyet;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Consumer3ApplicationTests {

    @Test
    void contextLoads() {
    }

}

@SpringBootTest(classes= WorldMeBlogApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestMock {
    @Autowired
    private AssetManager assetManager;
    @Test
    @Order(1)
    @Sql(scripts = {"test_post_before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    public void initData(){
        System.out.println("Init data");
        System.out.println("-----------------------------------------------------> INIT SIZE: "+assetManager.getLoves().size());
    }
    @Order(2)
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    @ParameterizedTest
    @CsvSource({
            "1,1"
    })
    public void test_postConstruct(int numb_1, int numb_2){
        System.out.println("-----------------------------------------------------> AFTER SIZE: "+assetManager.getLoves().size());
        assertEquals(numb_1,numb_2);
    }
    @Order(3)
    @ParameterizedTest
    @CsvSource({
            "1,1"
    })
    @Sql(scripts = "test_after.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void destroyData(int numb_1, int numb_2){
        System.out.println("Destroy data"); assertEquals(numb_1,numb_2);
    }
}
