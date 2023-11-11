import com.generation.model.Student;
import com.generation.service.StudentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.sql.Date;

public class StudentServiceTest {

    private StudentService studentService;

    @Before
    public void setUp() {
        studentService = new StudentService();
          Student studentTest = new Student("1", "Hans", "test@gmail.com", new Date(1995/8/30));
          studentService.subscribeStudent(studentTest);


    }

    @Test
    public void findStudentTest() {
        Assertions.assertNotNull(studentService.findStudent( "1" ) );
    }


    @Test
    public void isSubscribedTest() {
        Assertions.assertTrue(studentService.isSubscribed("1"));
    }
}
