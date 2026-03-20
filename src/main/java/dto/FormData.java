package dto;

import com.github.javafaker.Faker;
import lombok.Builder;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import wrappers.*;

@Getter
@Builder
public class FormData {

    WebDriver driver;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String subjects;
    private String currentAddress;
    private String permanentAddress;
    private String age;
    private String salary;
    private String department;


    public void apply(WebDriver driver, FormData form) {
        new Input(driver, "First Name").write(form.getFirstName());
        new Input(driver, "Last Name").write(form.getLastName());
        new Input(driver, "Email").write(form.getEmail());
        new Input(driver, "Mobile").write(form.getMobile());
        new Input(driver, "Subjects").write(form.getSubjects());
    }

    public void applyTextBox(WebDriver driver, FormData form) {
        new Input(driver, "Email").write(form.getEmail());
        new TextArea(driver, "Current Address").write(form.getCurrentAddress());
        new TextArea(driver, "Permanent Address").write(form.getPermanentAddress());
    }

    public void applySpecialFields(WebDriver driver, FormData form, String gender) {
        new RadioButton(driver,gender).select();
        new TextArea(driver, "Current Address").write(form.getCurrentAddress());
        new PickList(driver, "State and City").select("NCR");
    }

    public void useCheckbox(WebDriver driver, FormData form) {
        new Checkbox(driver, "Desktop").check();
        new Checkbox(driver, "Documents").check();
        new Checkbox(driver, "Downloads").check();
        new Checkbox(driver, "Home").check();
    }

    public void useWebPages(WebDriver driver, FormData form) {
        new Input(driver, "Last Name").write(getLastName());
        new Input(driver, "Email").write(getEmail());
        new Input(driver, "Age").write(getAge());
        new Input(driver, "Salary").write(getSalary());
        new Input(driver, "Department").write(getDepartment());
    }

    public void fillFirstName(WebDriver driver, FormData form) {
        new Input(driver, "First Name").write(firstName);
    }

}
