Feature: Login

    Scenario Outline: Login
        Given User is on sauce demo login page
        When User fill <username> and <password>
        And User click login button
        Then User verify login <result>

    Examples:
        |username           |password       |result     |
        |standard_user      |secret_sauce   |Passed     |
        |wrong_user         |secret_sauce   |Failed     |
        |standard_user      |wrong_password |Failed     |