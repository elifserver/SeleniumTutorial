Feature: Outlook Onboarding

@Ignore
  Scenario Outline: Create an account - Alternate Path::I should get proper error message for the Invalid email names 1
    Given I navigate to Outlook page
    And I click the Create account link for starting my process
    When I type "<memberName>" account name
    And I try to proceed
    Then I should get error message - "<message>"
    Examples:
      | memberName | message                                                   |
      | aaa        | Someone already has this email address. Try another name. |
    #  |            | An email address is required                              |
    #  | xxx        | xxx@outlook.com isn't available.|

  Scenario: Create an account - Happy Path
    Given I navigate to Outlook page
    And I click the Create account link for starting my process
    When I type "elif_server" account name
    And I try to proceed
    Then I should be landed on the password screen
