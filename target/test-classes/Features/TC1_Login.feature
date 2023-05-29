@Login
Feature: Verifying Adachin Hotel Login Details

  Scenario Outline: verifying adachin hotel login valid
    Given User is on the adachin page
    When User perform login "<userName>","<password>"
    Then User should verify after login sucess message "Hello nivak12345!"

    Examples: 
      | userName   | password  |
      | nivak12345 | 123456789 |

  Scenario Outline: Verifying adachin hotel login using Enter
    Given User is on the adachin page
    When User perform login "<userName>","<password>" with Enter Key
    Then User should verify after login sucess message "Hello nivak12345!"

    Examples: 
      | userName   | password  |
      | nivak12345 | 123456789 |

  Scenario Outline: Verifying adachin hotel login Invalid Credentials
    Given User is on the adachin page
    When User perform login "<userName>","<password>"
    Then User should verify after login with Invalid Credential error message contains "Invalid Login details or Your Password might have expired."

    Examples: 
      | userName   | password   |
      | nivak12345 | 9567842053 |
