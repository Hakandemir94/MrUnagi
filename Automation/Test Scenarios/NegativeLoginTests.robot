*** Settings ***
Library    DataDriver    ./TestData/invalid_credentials.csv    encoding=utf_8      dialect=excel
Resource   ../Resources/LoginKeywords.resource
Suite Teardown    Close Browser
Test Template    Login Test Template

*** Test Cases ***
Invalid login tests     username    password    error_message 
                        #In the above line, if the part after Invalid login tests is deleted, 
                        # ...it gives an error but the code will work anyway.
*** Keywords ***
Login Test Template
    [Arguments]    ${username}    ${password}    ${error_message}
    Given user is on the login page
    When user enters credentials    ${username}    ${password}
    And user clicks the login button
    Then correct error message should appear    ${error_message}