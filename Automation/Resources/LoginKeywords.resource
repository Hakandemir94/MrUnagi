*** Settings ***
Library         SeleniumLibrary
Library    OperatingSystem
Library    Collections
Library    String

*** Variables ***
${BROWSER}       Chrome
${URL}    https://www.saucedemo.com
${OPEN_MENU_BUTTON}    //button[@id='react-burger-menu-btn']
${CLOSE_MENU_BUTTON}    //button[@id='react-burger-cross-btn']
${LOGUOT_BUTTON}    //a[@id='logout_sidebar_link']

*** Keywords ***
user is on the login page
    Open Browser    ${URL}    ${BROWSER}
    Maximize Browser Window
    Title Should Be    Swag Labs    Page title is wrong.

user enters valid credentials
    Input Text    //input[@id='user-name']    standard_user
    Input Text    //input[@id='password']    secret_sauce

user clicks the login button
    Click Button    //input[@type='submit']

user should be on the dashboard
    Wait Until Page Contains    Products    3

user is logged in and on the dashboard
    user is on the login page
    user enters valid credentials
    user clicks the login button
    user should be on the dashboard

user opens the menu
    Click Button    ${OPEN_MENU_BUTTON}
    Wait Until Element Is Visible    ${CLOSE_MENU_BUTTON}    2

user clicks the logout button
    Click Element    ${LOGUOT_BUTTON}

user should be logged out and on the login page
    Title Should Be    Swag Labs    Page title is wrong after loguot.

user enters credentials
    [Arguments]    ${username}    ${password}
    Input Text    //input[@id='user-name']    ${username}
    Input Text    //input[@id='password']    ${password}

correct error message should appear
    [Arguments]    ${error_message}
    ${actual_error_message}=    Get Text    css=h3[data-test='error']
    Should Be Equal As Strings    ${actual_error_message}    ${error_message}