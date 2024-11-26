package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RevenueCalculatorPage;
import testBase.BaseClass;

public class TestRevenueCalculator extends BaseClass {
    @Test
    public void testRevenueCalculator() {
        logger.info("*** STARTED TESTING REVENUE CALCULATOR ***");

        try {
            // Step 1: Navigate to the FitPeo Homepage
            HomePage homepage = new HomePage(driver);
            logger.info("Navigated to the FitPeo Homepage.");

            // Step 2: Navigate to the Revenue Calculator Page
            homepage.clickLinkRevenueCalculator();
            logger.info("Clicked on the Revenue Calculator link.");

            // Step 3: Scroll Down to the Slider Section
            RevenueCalculatorPage rcp = new RevenueCalculatorPage(driver);
            rcp.scrollIntoView(rcp.sliderSection);
            logger.info("Scrolled to make the slider section visible.");

            // Step 4: Adjust the Slider to 820
            rcp.moveSliderTo("820");
            logger.info("Adjusted the slider to the target value of 820.");

            // Step 5: Update the Text Field to 560
            rcp.updateTextFieldTo("560");
            logger.info("Updated the text field to the target value of 560.");

            // Step 6: Validate Slider and Text Field Values
            Assert.assertEquals(rcp.getTextFieldValue(), rcp.getSliderValue(),
                    "Mismatch between Slider and Text Field values.");
            logger.info("Slider and Text Field values matched successfully.");

            // Reassigning textField to 820 (as per the assignment requirement)
            rcp.updateTextFieldTo("820");
            logger.info("Updated the text field back to 820 as per the assignment.");

            // Step 7: Select Required CPT Codes
            rcp.selectCheckBox_CPT99091();
            rcp.selectCheckBox_CPT99453();
            rcp.selectCheckBox_CPT99454();
            rcp.selectCheckBox_CPT99474();
            logger.info("Selected CPT Codes: CPT99091, CPT99453, CPT99454, CPT99474.");

            // Step 8: Validate Total Recurring Reimbursement
            String expectedTotal = "$110700";
            String actualTotal = rcp.getTotalRecurringReimbursement();
            Assert.assertEquals(actualTotal, expectedTotal,
                    "Total Recurring Reimbursement value does not match the expected value.");
            logger.info("Total Recurring Reimbursement value validated successfully.");

        }
        catch (AssertionError ae) {
            // Log and fail the test for assertion errors
            logger.error("Assertion failed: " + ae.getMessage(), ae);
            Assert.fail("Test failed due to assertion error. See logs for details.");

        }
        catch (Exception e) {
            // Log and fail the test for unexpected runtime exceptions
            logger.error("An unexpected error occurred: " + e.getMessage(), e);
            Assert.fail("Test failed due to an unexpected exception. See logs for details.");

        }
        finally {
            // Ensure the end of the test is logged
            logger.info("*** FINISHED TESTING REVENUE CALCULATOR ***");
        }
        //dvf
    }
}
