@SearchHotel
Feature: Verifying Adachin Search Hotel  Details

  Scenario Outline: Verifying Adachin Search Hotel by Selecting all fields With Valid Details
    Given User is on the adachin page
    When User perform login "<userName>","<password>"
    Then User should verify after login sucess message "Hello nivak12345!"
    When User select search hotel "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childernPerRoom>"
    Then User should verify after search to navigate select hotel sucess message "Select Hotel"

    Examples: 
      | userName   | password  | location | hotels      | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childernPerRoom |
      | nivak12345 | 123456789 | London   | Hotel Creek | Double   | 1 - One   | 24/02/2023  | 25/02/2023   | 1 - One       | 2 - Two         |

  Scenario Outline: Verifying Adachin Search Hotel by Selecting all fields with manatory fields
    Given User is on the adachin page
    When User perform login "<userName>","<password>"
    Then User should verify after login sucess message "Hello nivak12345!"
    When User select all manatory fields "<location>","<noOfRooms>","<checkInDate>","<checkOutDate>" and "<adultsPerRoom>"
    Then User should verify after search to navigate select hotel sucess message "Select Hotel"

    Examples: 
      | userName   | password  | location | noOfRooms | checkInDate | checkOutDate | adultsPerRoom |
      | nivak12345 | 123456789 | London   | 1 - One   | 24/02/2023  | 25/02/2023   | 1 - One       |

  Scenario Outline: Verifying Adactin Search Hotel by checking invalid date details
    Given User is on the adachin page
    When User perform login "<userName>","<password>"
    Then User should verify after login sucess message "Hello nivak12345!"
    When User select search invalied checkin and checkout date "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childernPerRoom>"
    Then User should verify after search hotel error message contains "Check-In Date shall be before than Check-Out Date" and "Check-Out Date shall be after than Check-In Date"

    Examples: 
      | userName   | password  | location | hotels      | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childernPerRoom |
      | nivak12345 | 123456789 | London   | Hotel Creek | Double   | 1 - One   | 14/06/2023  | 13/06/2023   | 1 - One       | 2 - Two         |

  Scenario Outline: Verifying without click any field details
    Given User is on the adachin page
    When User perform login "<userName>","<password>"
    Then User should verify after login sucess message "Hello nivak12345!"
    When User click search button without enter any fields
    Then User should verify after search with error message contains "Please Select a Location"

    Examples: 
      | userName   | password  |
      | nivak12345 | 123456789 |
