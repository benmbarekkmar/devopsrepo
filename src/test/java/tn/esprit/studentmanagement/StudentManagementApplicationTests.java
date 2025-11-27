package tn.esprit.studentmanagement;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;


@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource("classpath:application-test.properties")
class StudentManagementApplicationTests {
    @Test
    void contextLoads() {}
}
