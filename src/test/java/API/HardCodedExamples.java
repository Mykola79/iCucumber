package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.hamcrest.Matchers.*;


import static io.restassured.RestAssured.given;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODU0NjIxOTMsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NTUwNTM5MywidXNlcklkIjoiNTI4MyJ9.Q6fkVOl_Fy-YyApgJ3hX18lXOUP079y5px-vKC3o_YY";

    static String employee_id;

    @Test
    public void bgetCreatedEmployee(){
        RequestSpecification prepareRequest = given()                   //create request
                .header("Content-Type","application/json")
                .header("Authorization",token)
                .queryParam("employee_id",employee_id);




        //hitting endpoint
        Response response = prepareRequest.when()                       //response
                .get("/getOneEmployee.php");
        response.prettyPrint();




        //verify the response
        response.then()                                                 //verify
                .assertThat().statusCode(200);

        String tempEmpId = response.jsonPath().getString("employee.employee_id");

        //we have 2 emp id, one is global and second is local

        Assert.assertEquals(employee_id,tempEmpId);

    }



   @Test
    public void acreateEmployee() {
        //prepare the request
        RequestSpecification request = given()
                .header("Content-Type", "application/json")
                .header("Authorization", token)
                .body("{\n" +
                        "    \"emp_firstname\": \"Bob\",\n" +
                        "    \"emp_lastname\": \"Bober\",\n" +
                        "    \"emp_middle_name\": \"ms\",\n" +
                        "    \"emp_gender\": \"M\",\n" +
                        "    \"emp_birthday\": \"1999-09-29\",\n" +
                        "    \"emp_status\": \"Confirmed\",\n" +
                        "    \"emp_job_title\": \"Engineer\"\n" +
                        "}");


        //hitting the endpoint
        Response response = request.when()
                .post("/createEmployee.php");
        //it will print the output in the console
        response.prettyPrint();

        String expectedValue = "Employee Created";
        String actualValue = response.jsonPath().getString("Message");

        //System.out.println(actualValue);
        Assert.assertEquals(actualValue,expectedValue);


        String expected = "Engineer";
        String actual = response.jsonPath().getString("Employee.emp_job_title");
        Assert.assertEquals(actual,expected);


        //verifying the assertions
        response.then()
                .assertThat().statusCode(201);
        //we are capturing employee id from the response

       employee_id = response.jsonPath()
                .getString("Employee.employee_id");

        response.then()
                .assertThat().body("Employee.emp_firstname", equalTo("Bob"));

        response.then()
                .assertThat().body("Employee.emp_lastname", equalTo("Bober"));
        //verify the response headers
        response.then()
                .assertThat().header("Content-Type", "application/json");

        System.out.println("My test passed");


    }
    //homework, create a method to get all employee status and job title

    @Test
    public void ejobTitle(){

        RequestSpecification prepareRequest = given()
                .header("Authorization",token);


        Response response = prepareRequest.when()
                .get("/jobTitle.php");
        response.prettyPrint();


        response.then()
                .assertThat().statusCode(200);

    }

    @Test
    public void femploymentStatus(){

        RequestSpecification prepareRequest = given()
                .header("Authorization",token);



        Response response = prepareRequest.when()
                .get("/employeementStatus.php");
        response.prettyPrint();


        response.then()
                .assertThat().statusCode(200);


    }



    @Test
    public void cupdateEmployee(){

        RequestSpecification prepareRequest = given()
                .header("Content-Type","application/json")
                .header("Authorization",token)
                .body("{\n" +
                        "  \"employee_id\": \""+employee_id+"\",\n" +
                        "  \"emp_firstname\": \"Roy\",\n" +
                        "  \"emp_lastname\": \"Royel\",\n" +
                        "  \"emp_middle_name\": \"msu\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2003-03-23\",\n" +
                        "  \"emp_status\": \"probation\",\n" +
                        "  \"emp_job_title\": \"Director\"\n" +
                        "}");



        Response response = prepareRequest.when()
                        .put("/updateEmployee.php");




                response.then()
                        .assertThat().statusCode(200);

                response.then()
                        .assertThat().body("Message",equalTo("Employee record Updated"));
    }

    @Test
    public void dgetUpdatedEmployee(){
        RequestSpecification prepareRequest = given()
                .header("Content-Type","application/json")
                .header("Authorization",token)
                .queryParam("employee_id",employee_id);





        Response response = prepareRequest.when()
                .get("/getOneEmployee.php");
        response.prettyPrint();





        response.then()
                .assertThat().statusCode(200);
        //if you want to verify the body of the response.
        //you can do that using hamcrest matchers
    }
}
