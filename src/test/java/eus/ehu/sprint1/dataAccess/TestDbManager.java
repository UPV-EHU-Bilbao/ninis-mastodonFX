package eus.ehu.sprint1.dataAccess;


import eus.ehu.sprint1.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class TestDbManager {


    DbAccessManager dbManager;


    @BeforeEach
    public void setUp() {
        dbManager = new DbAccessManager();
    }


    @AfterEach
    public void tearDown() {
        dbManager.close();
    }


    @Test
    void test_my_first_object_to_the_db() {
        User Iturri = new User("Iturri", "1234");
        dbManager.storeUser(Iturri);
    }
}
