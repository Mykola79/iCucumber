package Utils;

import netscape.javascript.JSException;
import netscape.javascript.JSObject;
import org.json.JSONObject;

public class APIPayloadConstants {

    public static String createEmployeePayload() {
        String createEmployeePayload = "{\n" +
                "    \"emp_firstname\": \"Bob\",\n" +
                "    \"emp_lastname\": \"Bober\",\n" +
                "    \"emp_middle_name\": \"ms\",\n" +
                "    \"emp_gender\": \"M\",\n" +
                "    \"emp_birthday\": \"1999-09-29\",\n" +
                "    \"emp_status\": \"Confirmed\",\n" +
                "    \"emp_job_title\": \"Engineer\"\n" +
                "}";
        return createEmployeePayload;
    }


    public static String createEmployeePayloadJson() {

        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", "Bob");
        obj.put("emp_lastname", "Bober");
        obj.put("emp_middle_name", "ms");
        obj.put("emp_gender", "M");
        obj.put("emp_birthday", "1999-09-29");
        obj.put("emp_status", "Confirmed");
        obj.put("emp_job_title", "Engineer");
        return obj.toString();

    }


    public static String createEmployeePayloadDynamic(String emp_firstname, String emp_lastname, String emp_middle_name, String emp_gender, String emp_birthday, String emp_status, String emp_job_title) {

        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", emp_firstname);
        obj.put("emp_lastname", emp_lastname);
        obj.put("emp_middle_name", emp_middle_name);
        obj.put("emp_gender", emp_gender);
        obj.put("emp_birthday", emp_birthday);
        obj.put("emp_status", emp_status);
        obj.put("emp_job_title", emp_job_title);
        return obj.toString();
    }


    public static String updateEmployeePayloadJson() {

        JSONObject obj = new JSONObject();
        obj.put("employee_id", "54253A");
        obj.put("emp_firstname", "Roy");
        obj.put("emp_lastname", "Royel");
        obj.put("emp_middle_name", "msu");
        obj.put("emp_gender", "M");
        obj.put("emp_birthday", "2003-03-23");
        obj.put("emp_status", "probation");
        obj.put("emp_job_title", "Director");
        return obj.toString();

    }
}
