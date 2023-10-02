Starting the app:
1. Make sure port 8080 is available on your machine
2. Load project in Intellij Idea
3. Right click Application class in project
4. select run/rebug option
5. Open link http://localhost:8080/v1/test to check if app is running

Endpoints logic

**PATH:**               /v1/numbers

**METHOD:**             GET

**QUERY_PARAMETERS:**   amount [1...10]

**Description:**

_This endpoint returns a JSON of 1 to 10 phone numbers formatted as +47072XXXXXXX where X is a digit between 0 and 9._

