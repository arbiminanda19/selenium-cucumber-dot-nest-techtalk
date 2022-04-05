Feature: Order

    Scenario Outline: Order
        Given User is on sauce demo login page
        When User fill <username> and <password>
        And User click login button
        Then User verify login <result>
        When User add product to cart
        And User click cart button
        And User click check out button
        Then User is on check out page
        When User fill check out info
        And User click continue button
        And User overview and finish order
        Then User is on thank you order page

    Examples:
        |username           |password       |result     |
        |standard_user      |secret_sauce   |Passed     |