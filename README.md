# SKILLO EXAM

## LoginTest.java

This file contains a test class `LoginTest` for testing a login functionality. It includes the following methods:

### Class: `LoginTest`
- **Methods:**
    - `getUsers()`: Provides test data for the login test.
    - `loginTest(String username, String password, String userId)`: Executes the login test with provided credentials.

- **Annotations:**
    - `@DataProvider(name = "getUser")`: Provides test data to the `loginTest` method.

- **Dependencies:**
    - Uses TestNG for annotations and test execution.
    - Utilizes WebDriverManager to manage the Chrome driver setup.

- **Test Steps:**
    - Navigates to the home page, verifies the page is loaded.
    - Clicks the login button, verifies the login page is loaded.
    - Fills in the username and password, checks the "Remember Me" option.
    - Verifies the successful login message and the display of certain elements.
    - Clicks on the profile link and verifies the profile page for the specified user ID is loaded.

Ensure the Chrome driver setup is handled correctly in `beforeTest()`
and closed in `afterTest()` for proper test execution. The `loginTest()` method executes the login test
scenario with provided user credentials.


## LogoutTest.java

### Class: LogoutTest
- **Methods:**
    - `getUsers()`: Provides test data for the login test.
    - `loginTest(String username, String password)`: Executes the login test with provided credentials.

- **Annotations:**
    - `@DataProvider(name = "getUser")`: Data provider for test data.

- **Dependencies:**
    - Uses TestNG for testing framework.
    - WebDriverManager for managing WebDriver configurations.

- **Test Steps:**
    - Navigates to the home page and verifies its loading.
    - Clicks the login button and verifies the login page is loaded.
    - Enters username and password, checks the "Remember Me" option.
    - Clicks the sign-up button and verifies the home page is loaded again.
    - Clicks on the down arrow for logout.
    - Verifies the current page is the profile page.

Ensure proper setup and tear down of the Chrome driver for successful test execution.


## RegisterTest.java

### Class: RegisterTest
- **Methods:**
  
  - `getUsers()`: Provides test data for the registration test.
  - `registerTest(String userNameRegister, String email, String password, String confirmPassword)`: Executes the registration test with provided data.
  - `generateRandomEmail(int minLenghtInclusive, int maxLenghtInclusive)`: Generates a random email address.
  - `generateAlphabeticString(int minLenghtInclusive, int maxLenghtInclusive)`: Generates a random alphabetic string.

- **Annotations:**

  - `@DataProvider(name = "getUser")`: Provides test data for the registration test.

- **Test Steps:**
  - Registers a new user with the provided username, email, password, and confirmation.
  - Validates the registration process and user profile.

Ensure proper Chrome driver setup and tear down for successful test execution.


 ## PostTest Class

## Description
The `PostTest` class contains test methods related to creating a post on a website. It utilizes Selenium WebDriver for web testing and TestNG for test annotations.

## Test Methods
- `testCreatePost(String username, String password, String userId, File postPicture, String caption)`: This method tests the creation of a post by logging in with provided credentials, uploading a picture, adding a caption, and verifying the post creation.

## Data Provider
- `getUsers()`: Provides test data including username, password, user ID, post picture, and caption for the `testCreatePost` method.

## Dependencies
- Uses WebDriver for browser automation.
- Relies on TestNG for test execution.

## Usage
1. Ensure the necessary dependencies are set up.
2. Run the `testCreatePost` method with valid test data.

## Notes
- Make sure to update the test data in the `getUsers` data provider method as needed.
- Verify the correctness of the test execution by checking the expected outcomes.


# FolowPostTest Class

## Description
The `FolowPostTest` class contains test methods related to following and liking posts on a social media platform. It uses Selenium WebDriver for web testing and TestNG for test annotations.

## Test Methods
- `testCreatePost(String username, String password, String userId, File postPicture, String caption)`: This method tests the creation of a post by logging in with the provided credentials, uploading a picture, adding a caption, and verifying the post creation.

## Data Provider
- `getUsers()`: Provides test data including username, password, user ID, post picture, and caption for the `testCreatePost` method.

## Dependencies
- Utilizes WebDriver for browser automation.
- Depends on TestNG for test execution.

## Usage
1. Ensure the necessary dependencies are correctly set up.
2. Run the `testCreatePost` method with valid test data.

## Notes
- Update the test data in the `getUsers` data provider method as required.
- Verify the test results to ensure the expected outcomes are met.

