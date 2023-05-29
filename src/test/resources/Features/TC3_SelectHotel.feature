@SelectHotel
Feature: Verifying Adachin Select Hotel  Details

  Scenario Outline: Verifying Adachin Select Hotel Valid
    Given User is on the adachin page
    When User perform login "<userName>","<password>"
    Then User should verify after login sucess message "Hello nivak12345!"
    When User select search hotel "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childernPerRoom>"
    Then User should verify after search to navigate select hotel sucess message "Select Hotel"
    When User perform continue with select hotel name
    Then User should verify after continue to navigate Book a hotel with success message "Book A Hotel"

    Examples: 
      | userName   | password  | location | hotels      | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childernPerRoom |
      | nivak12345 | 123456789 | London   | Hotel Creek | Double   | 1 - One   | 24/02/2023  | 25/02/2023   | 1 - One       | 2 - Two         |

  Scenario Outline: Verifying Adachin Select Hotel without select any hotels
    Given User is on the adachin page
    When User perform login "<userName>","<password>"
    Then User should verify after login sucess message "Hello nivak12345!"
    When User select search hotel "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childernPerRoom>"
    Then User should verify after search to navigate select hotel sucess message "Select Hotel"
    When User perform continue without select hotel name
    Then User should verify after continue to navigate Book a hotel with error success message contains "Please Select a Hotel"

    Examples: 
      | userName   | password  | location | hotels      | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childernPerRoom |
      | nivak12345 | 123456789 | London   | Hotel Creek | Double   | 1 - One   | 24/02/2023  | 25/02/2023   | 1 - One       | 2 - Two         |
