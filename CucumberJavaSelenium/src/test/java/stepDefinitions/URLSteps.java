package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

public class URLSteps {
	static int startDate = 23;
	static int endDate = 24;
	static String number;
	static String trimmed;
	WebDriver driver = new ChromeDriver();
    @Given("user is on login page")
    public void user_is_on_login_page() {
        driver.get("https://yexletest.appiancloud.com/suite/sites/leave-management-system");
        driver.manage().window().maximize();
    }

    @When("user enters valid username")
    public void user_enters_the_valid() {
     driver.findElement(By.id("un")).sendKeys("saiprathyusha.kaja@yexle.com");
    }

    @And("enters valid password")
    public void enters_the_valid() {
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Prathyusha2025");
    }

    @And("clicks on signin button")
    public void user_clicks_on_login_button() {
       driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Then("user navigated to the main page")
    public void user_navigated_to_the_main_page() throws Exception {
        try {
        	Thread.sleep(3000);
            WebElement gridName = driver.findElement(By.className("Button---accessibilityhidden"));

            // Check if the element is displayed, indicating the correct page
            if (gridName.isDisplayed()) {
                System.out.println("User successfully navigated to the main page.");
            } else {
                System.out.println("Element found but not visible. User may not be on the expected page.");
            }
        } catch (NoSuchElementException e) {
            // Handle the case where the element is not found
            System.err.println("Element 'Leave Requests' not found. User is not on the expected page.");
            throw e; // Rethrow exception to fail the test if necessary
        }
    }
    
    @Given("user clicked on apply leave button")
	public void user_clicked_on_apply_leave_button() {
	   driver.findElement(By.xpath("//span[normalize-space(text())='Apply Leave']")).click();
	}
    
    @When("user navigated to the Apply leave screen")
	public void user_navigated_to_the_apply_leave_screen() throws Exception {
    	 try {
         	Thread.sleep(3000);
             WebElement gridName = driver.findElement(By.xpath("//span[contains(text(),'New Leave Details')]"));

             // Check if the element is displayed, indicating the correct page
             if (gridName.isDisplayed()) {
                 System.out.println("User successfully navigated to apply leave screen");
             } else {
                 System.out.println("Element found but not visible. User may not be on the expected page.");
             }
         } catch (NoSuchElementException e) {
             // Handle the case where the element is not found
             System.err.println("Element 'New Leave Details' not found. User is not on the expected page.");
             throw e; // Rethrow exception to fail the test if necessary
         }
	}

	@And("user selects the value from the leave reason dropdown")
	public void user_selects_the_value_from_the_leave_reason_dropdown() {
		WebElement dropdown = driver.findElement(By.xpath("(//div[@class= 'DropdownWidget---wrapper'])[1]"));
		dropdown.click();
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_DOWN) // Move to the next option
	       .sendKeys(Keys.ARROW_DOWN) // Move to the second option
	       .sendKeys(Keys.ENTER)      // Select the highlighted option
	       .perform();
		String value = dropdown.getText();
		System.out.println("Successfully selected the leave reason: " +value);		
	}

	@And("selects the value in date from field")
	public void selects_the_value_in_date_from_field() {
	    driver.findElement(By.xpath("(//button[@class=\"DatePickerWidget---calendar_btn\"])[1]")).click();
	    driver.findElement(By.xpath("//table[@class=\"DatePicker---calendar\"]//tbody//descendant::span[text()="+startDate+"]")).click();
	}

	@And("selects the value in date to field")
	public void selects_the_value_in_date_to_field() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='DatePickerWidget---calendar_btn'])[2]"))).click();
//		driver.findElement(By.xpath("(//button[@class='DatePickerWidget---calendar_btn'])[2]")).click();
	   driver.findElement(By.xpath("//table[@class='DatePicker---calendar']//tbody//descendant::span[text()="+endDate+"]")).click();
	}

	@And("enters comments")
	public void enters_comments() {
	    driver.findElement(By.xpath("//textarea[@role=\"textbox\"]")).sendKeys("Applying leave for 2 days");
	}

	@And("clicks on apply button")
	public void clicks_on_apply_button() {
	   driver.findElement(By.xpath("//button//descendant::span[contains(text(),\"APPLY\")]")).click();
	}
	
	@And("user checking the reference number")
	public void user_checking_the_reference_number() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement refNumber = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),\"LMS\")]")));
		number = refNumber.getText();
		System.out.println(number);
	}
	
	@And("clicks on close button")
	public void clicks_on_close_button() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=\"CLOSE\"]"))).click();
	}
	
	@And("user navigated to the leave request list")
	public void user_navigated_to_the_leave_request_list() throws InterruptedException {
		try {
        	Thread.sleep(3000);
            WebElement gridName = driver.findElement(By.className("Button---accessibilityhidden"));

            // Check if the element is displayed, indicating the correct page
            if (gridName.isDisplayed()) {
                System.out.println("User successfully navigated to the main page.");
            } else {
                System.out.println("Element found but not visible. User may not be on the expected page.");
            }
        } catch (NoSuchElementException e) {
            // Handle the case where the element is not found
            System.err.println("Element 'Leave Requests' not found. User is not on the expected page.");
            throw e; // Rethrow exception to fail the test if necessary
        }
	}
	
	@When("user search the leave request using search filter")
	public void user_search_the_leave_request_using_search_filter() {
		trimmed = number.substring(1);
		System.out.println(trimmed);
		driver.findElement(By.xpath("//input[@placeholder='Search Leave Requests']")).sendKeys(trimmed);
		driver.findElement(By.xpath("//span[contains(text(),'Search')]")).click();
	}
	
	@Then("the leave request row should be visible")
	public void the_leave_request_row_should_be_visible() {
		WebElement gridNumber = driver.findElement(By.xpath("//table//tbody//descendant::a[contains(text(),\"LMS\")]"));
		String number2 = gridNumber.getText();
		System.out.println(number2);
		if(trimmed.equals(number2)) {
			System.out.println("Number found");
		}else {
			System.out.println("Number not found");
		}
	}
}
