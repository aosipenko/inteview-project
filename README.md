## Starting the app:

1. Make sure port 8080 is available on your machine
2. Load project in Intellij Idea
3. Right click Application class in project
4. select run/rebug option
5. Open link http://localhost:8080/v1/test to check if app is running

## Endpoints logic

### Get Numbers Endpoint

- PATH:               `/v1/numbers`
- METHOD:             `GET`
- QUERY_PARAMETERS: `amount [1...10]`
- Description:
  _This endpoint returns a JSON of `1` to `10` phone numbers formatted as `+47072XXXXXXX` where `X` is a digit between `0` and `9`._

### switch phone number endpoint

- PATH:               `/v1/switch/numbers`
- METHOD:             `PUT`
- REQUEST_BODY
    - JSON: `{"old_number":"+47072XXXXXXX", "new_number":"+47072XXXXXXX"}`
    - must support `+47072XXXXXXX` and `47072XXXXXXX` format
    - phone number length must be `12` digits
    - only `47072XXXXXXX` numbers are allowed
- RESPONSE_BODY:
    - JSON: `{"new_number":"+47072XXXXXXX"}`
    - must return only new number
    - number should be the same format as it was sent
- Description:
  _This endpoint imitates switch of phone numbers for our clients. Client sends a request with old phone and new number
  in it. As a response we must confirm all is OK (200) if both numbers are valid, and return the new number only_

### register new user endpoint

- PATH:               `/v1/user`
- METHOD:             `POST`
- REQUEST_BODY
    - JSON: `{
      "firstName": "Test",
      "lastName": "Test",
      "personalNumber": "123456789012",
      "phoneNumber": "+470729615408"
      }`
    - must support `+47072XXXXXXX` and `47072XXXXXXX` format
    - phone number length must be `12` digits
    - personal number length must be `12` digits
    - only `47072XXXXXXX` numbers are allowed
    - `firstName` and `lastName` must not be empty
- RESPONSE_BODY:
    - "OK"
- Description:
  _This endpoitn validates consistency of user data: first and last name, personal id and phone number_