package API;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodeExamples {
    // storing the based UIR to use further
    String baseURI=RestAssured.baseURI= "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token ="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NDU4ODg2OTksImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY0NTkzMTg5OSwidXNlcklkIjoiMzUwOCJ9.5DpABb0uLOBB2WB1MjZ1CgAF4hSSx4pB-RhmR8ifLAY";
   static String employee_id;
@Test
    public void bGetCreatedEmployee(){


        // preparing the request to get an employee
        RequestSpecification preparedRequest= given().header("Content-Type","application/json")
                .header("Authorization",token)
                .queryParam("employee_id",employee_id);

        Response response=preparedRequest.when().get("/getOneEmployee.php");
        //System.out.println(response.asString());

        response.prettyPrint();
        String emdId=response.jsonPath().getString("employee.employee_id");

        boolean comparingEmpIDs=emdId.contentEquals(employee_id);
        Assert.assertTrue(comparingEmpIDs);
        response.then().assertThat().statusCode(200);

        String middleName=response.jsonPath().getString("employee.emp_middle_name");
        Assert.assertTrue(middleName.contentEquals("cosby"));
}
    // to create an employee
    @Test
    public void acreateEmployee(){

    RequestSpecification preparedRequest=given().header("Content-Type","application/json")
            .header("Authorization",token).body("{\n" +
                "  \"emp_firstname\": \"Jose\",\n" +
                "  \"emp_lastname\": \"Pool\",\n" +
                "  \"emp_middle_name\": \"cosby\",\n" +
                "  \"emp_gender\": \"F\",\n" +
                "  \"emp_birthday\": \"1996-07-15\",\n" +
                "  \"emp_status\": \"Employed\",\n" +
                "  \"emp_job_title\": \"QA\"\n" +
                "}");

                Response response=preparedRequest.when().post("/createEmployee.php");
                response.prettyPrint();

              employee_id=  response.jsonPath().getString("Employee.employee_id");
              System.out.println(employee_id);

    }

    @Test
    public void cupdateEmployee(){
    //update the existing employee
        RequestSpecification preparedRequest=given().header("Authorization",token).
                header("Content-Type","application/json").body("{\n" +
                        "  \"employee_id\": \""+ employee_id+"\",\n" +
                        "  \"emp_firstname\": \"Ben\",\n" +
                        "  \"emp_lastname\": \"ver\",\n" +
                        "  \"emp_middle_name\": \"Do\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2001-02-20\",\n" +
                        "  \"emp_status\": \"Employee\",\n" +
                        "  \"emp_job_title\": \"catcher\"\n" +
                        "}");
        Response response=preparedRequest.when().put("/updateEmployee.php");
        response.prettyPrint();

        response.then().assertThat().body("Message",equalTo("Employee record Updated"));
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void dGetUpdatedEmployee(){
        //storing the base uri to use further

        //preparing the request to get an employee
        RequestSpecification preparedRequest = given().header("Content-Type", "application/json").
                header("Authorization", token).
                queryParam("employee_id",employee_id);

        Response response = preparedRequest.when().get("/getOneEmployee.php");

        //  System.out.println(response.asString());

        //prettyprint does the same as system.out.println
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

        String middleName = response.jsonPath().getString("employee.emp_middle_name");
        Assert.assertTrue(middleName.contentEquals("Do"));

    }
@Test
    public void eGetAllEmployees(){

    RequestSpecification preparedRequest=given().header("Authorization",token).header("Content-Type","application/json");

    Response response=preparedRequest.when().get("/getAllEmployees.php");

    String allEmployees=response.prettyPrint();

    JsonPath js=new JsonPath(allEmployees);

    int count=js.getInt("Employees.size");
        System.out.println(count);

        // print all the employees id's from response
        for(int i=0; i<count;i++){
            String employeeIds= js.getString("Employees["+ i+"].employee_id");
            System.out.println(employeeIds);
        }

    }

}
