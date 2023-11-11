import com.generation.model.Course;
import com.generation.model.Module;
import com.generation.model.Student;
import com.generation.service.CourseService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import java.sql.Date;


public class CourseServiceTest {

        private CourseService courseService;

        @Before
        public void setUp() {
                courseService = new CourseService();
                Module module = new Module( "INTRO-CS", "Introduction to Computer Science", "Introductory module for the generation technical programs" );
                courseService.registerCourse( new Course( "INTRO-CS-1", "Introduction to Computer Science", 9, module ) );
                Student studentTest = new Student("1", "Hans", "test@gmail.com", new Date(1995/8/30));


        }

        @Test
        public void getCourseTest() {
                Assertions.assertNotNull(courseService.getCourse( "INTRO-CS-1" ) );
        }


        @Test
        public void averageGradesTest() {
                Assertions.assertEquals( 0, courseService.averageGrades( "INTRO-CS-1" ) );
        }

}


