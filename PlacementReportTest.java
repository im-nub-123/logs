import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlacementReportTest {

    private PlacementReport placementReport;

    @BeforeEach
    void setUp() {
        placementReport = new PlacementReport();
        System.out.println("Starting Test...");
    }

    @AfterEach
    void tearDown() {
        placementReport = null;
        System.out.println("Test Completed.");
    }

    // -----------------------------
    // HIGHLY ELIGIBLE Test Cases
    // -----------------------------

    @Test
    @DisplayName("CGPA Lower Boundary for Highly Eligible")
    void testHighlyEligibleLowerBoundary() throws InvalidStudentException {
        assertEquals("HIGHLY ELIGIBLE",
                placementReport.evaluatePlacementEligibility(8.0));
    }

    @Test
    @DisplayName("CGPA Mid Value for Highly Eligible")
    void testHighlyEligibleMidValue() throws InvalidStudentException {
        assertEquals("HIGHLY ELIGIBLE",
                placementReport.evaluatePlacementEligibility(9.2));
    }

    @Test
    @DisplayName("CGPA Upper Boundary for Highly Eligible")
    void testHighlyEligibleUpperBoundary() throws InvalidStudentException {
        assertEquals("HIGHLY ELIGIBLE",
                placementReport.evaluatePlacementEligibility(10.0));
    }

    // -----------------------------
    // ELIGIBLE Test Cases
    // -----------------------------

    @Test
    @DisplayName("CGPA Lower Boundary for Eligible")
    void testEligibleLowerBoundary() throws InvalidStudentException {
        assertEquals("ELIGIBLE",
                placementReport.evaluatePlacementEligibility(6.5));
    }

    @Test
    @DisplayName("CGPA Mid Value for Eligible")
    void testEligibleMidValue() throws InvalidStudentException {
        assertEquals("ELIGIBLE",
                placementReport.evaluatePlacementEligibility(7.2));
    }

    @Test
    @DisplayName("CGPA Upper Boundary for Eligible")
    void testEligibleUpperBoundary() throws InvalidStudentException {
        assertEquals("ELIGIBLE",
                placementReport.evaluatePlacementEligibility(7.9));
    }

    // -----------------------------
    // MARGINAL ELIGIBILITY Test Cases
    // -----------------------------

    @Test
    @DisplayName("CGPA Lower Boundary for Marginal Eligibility")
    void testMarginalEligibilityLowerBoundary() throws InvalidStudentException {
        assertEquals("MARGINAL ELIGIBILITY",
                placementReport.evaluatePlacementEligibility(5.0));
    }

    @Test
    @DisplayName("CGPA Mid Value for Marginal Eligibility")
    void testMarginalEligibilityMidValue() throws InvalidStudentException {
        assertEquals("MARGINAL ELIGIBILITY",
                placementReport.evaluatePlacementEligibility(5.8));
    }

    @Test
    @DisplayName("CGPA Upper Boundary for Marginal Eligibility")
    void testMarginalEligibilityUpperBoundary() throws InvalidStudentException {
        assertEquals("MARGINAL ELIGIBILITY",
                placementReport.evaluatePlacementEligibility(6.4));
    }

    // -----------------------------
    // Invalid CGPA Test Cases
    // -----------------------------

    @Test
    @DisplayName("CGPA Below Minimum Should Throw Exception")
    void testCgpaBelowMinimum() {
        assertThrows(InvalidStudentException.class, () -> {
            placementReport.evaluatePlacementEligibility(4.9);
        });
    }

    @Test
    @DisplayName("Negative CGPA Should Throw Exception")
    void testNegativeCgpa() {
        assertThrows(InvalidStudentException.class, () -> {
            placementReport.evaluatePlacementEligibility(-2.0);
        });
    }

    @Test
    @DisplayName("CGPA Above Maximum Should Throw Exception")
    void testCgpaAboveMaximum() {
        assertThrows(InvalidStudentException.class, () -> {
            placementReport.evaluatePlacementEligibility(10.1);
        });
    }
}
