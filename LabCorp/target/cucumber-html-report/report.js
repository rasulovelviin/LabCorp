$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/UserAPI.feature");
formatter.feature({
  "name": "LabCorp UserAPI scenarios",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Add new user - End to ENd scenario",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Test"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User create json request data",
  "rows": [
    {
      "cells": [
        "createdAt",
        "employee_firstname",
        "employee_lastname",
        "employee_phonenumbe",
        "ademployee_emaildress",
        "citemployee_addressy",
        "stateemployee_dev_level",
        "employee_gender",
        "employee_hire_date",
        "employee_onleave"
      ]
    },
    {
      "cells": [
        "1631825833",
        "John",
        "Smith",
        "264-783-9453",
        "johnSmith@gmail.com",
        "Reston",
        "Virginia",
        "male",
        "2025-10-31T163545.426Z",
        "true"
      ]
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "UserAPISteps.user_create_json_request_data(DataTable)"
});
formatter.write("{\r\n  \"createdAt\" : 1631825833,\r\n  \"employee_firstname\" : \"John\",\r\n  \"employee_lastname\" : \"Smith\",\r\n  \"employee_phonenumbe\" : \"264-783-9453\",\r\n  \"ademployee_emaildress\" : \"johnSmith@gmail.com\",\r\n  \"citemployee_addressy\" : \"Reston\",\r\n  \"stateemployee_dev_level\" : \"Virginia\",\r\n  \"employee_gender\" : \"male\",\r\n  \"employee_hire_date\" : \"2025-10-31T163545.426Z\",\r\n  \"employee_onleave\" : true,\r\n  \"tech_stack\" : null,\r\n  \"project\" : null\r\n}");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User submit POST request",
  "keyword": "When "
});
formatter.match({
  "location": "UserAPISteps.user_submit_POST_request()"
});
formatter.write("{\n    \"createdAt\": 1631825833,\n    \"employee_firstname\": \"John\",\n    \"employee_lastname\": \"Smith\",\n    \"employee_phonenumbe\": \"264-783-9453\",\n    \"ademployee_emaildress\": \"johnSmith@gmail.com\",\n    \"citemployee_addressy\": \"Reston\",\n    \"stateemployee_dev_level\": \"Virginia\",\n    \"employee_gender\": \"male\",\n    \"employee_hire_date\": \"2025-10-31T163545.426Z\",\n    \"employee_onleave\": true,\n    \"tech_stack\": null,\n    \"project\": null,\n    \"id\": \"232\"\n}");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User validate statusCode is 201",
  "keyword": "Then "
});
formatter.match({
  "location": "UserAPISteps.user_validate_statusCode_is(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User retrives recordID from response",
  "keyword": "And "
});
formatter.match({
  "location": "UserAPISteps.user_retrives_recordID_from_response()"
});
formatter.write("Record ID: 232");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User submits GET request with record ID",
  "keyword": "And "
});
formatter.match({
  "location": "UserAPISteps.user_submits_GET_request_with_record_ID()"
});
formatter.write("{\n    \"createdAt\": 1631825833,\n    \"employee_firstname\": \"John\",\n    \"employee_lastname\": \"Smith\",\n    \"employee_phonenumbe\": \"264-783-9453\",\n    \"ademployee_emaildress\": \"johnSmith@gmail.com\",\n    \"citemployee_addressy\": \"Reston\",\n    \"stateemployee_dev_level\": \"Virginia\",\n    \"employee_gender\": \"male\",\n    \"employee_hire_date\": \"2025-10-31T163545.426Z\",\n    \"employee_onleave\": true,\n    \"tech_stack\": null,\n    \"project\": null,\n    \"id\": \"232\"\n}");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User validates if user is created and exist",
  "keyword": "And "
});
formatter.match({
  "location": "UserAPISteps.user_validates_if_user_is_created_and_exist()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User delete the record",
  "keyword": "And "
});
formatter.match({
  "location": "UserAPISteps.user_delete_the_record()"
});
formatter.result({
  "status": "passed"
});
});