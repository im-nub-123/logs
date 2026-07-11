import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UniversityTest {

    // Test 1: Verify that the returned list is not null
    @Test
    void testCoursesListNotNull() {
        List<String> actualCourses = University.coursesList();
        assertNotNull(actualCourses);
    }

    // Test 2: Verify that the list contains the expected number of courses
    @Test
    void testCoursesListSize() {
        List<String> actualCourses = University.coursesList();

        List<String> expectedCourses = Arrays.asList(
                "Computer Science",
                "Mathematics",
                "Physics",
                "Chemistry"
        );

        assertIterableEquals(expectedCourses, actualCourses);
        assertEquals(4, actualCourses.size());
    }

    // Test 3: Verify that the list contains the exact course names in the correct order
    @Test
    void testCoursesListContentAndOrder() {
        List<String> actualCourses = University.coursesList();

        List<String> expectedCourses = Arrays.asList(
                "Computer Science",
                "Mathematics",
                "Physics",
                "Chemistry"
        );

        assertIterableEquals(expectedCourses, actualCourses);
    }
}
