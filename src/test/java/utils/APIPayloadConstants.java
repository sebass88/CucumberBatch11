package utils;

public class APIPayloadConstants {

    public static String createEmployeePayload(){
        String createEmployeePayload = "{\n" +
                "  \"emp_firstname\": \"Ben\",\n" +
                "  \"emp_lastname\": \"Ver\",\n" +
                "  \"emp_middle_name\": \"Do\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"1988-02-28\",\n" +
                "  \"emp_status\": \"Employee\",\n" +
                "  \"emp_job_title\": \"catcher\"\n" +
                "}";

        return createEmployeePayload;
    }

}
