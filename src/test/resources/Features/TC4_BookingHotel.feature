@BookingHotel
Feature: Verifying Adachin Select Hotel  Details

  Scenario Outline: Verifying Adachin Select Hotel Details
    Given User is on the adachin page
    When User perform login "<userName>","<password>"
    Then User should verify after login sucess message "Hello nivak12345!"
    When User select search hotel "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childernPerRoom>"
    Then User should verify after search to navigate select hotel sucess message "Select Hotel"
    When User perform continue with select hotel name
    Then User should verify after continue to navigate Book a hotel with success message "Book A Hotel"
    When user book hotel "<firstName>","<lastName>" and "<billingAddress>"
      | creditCardNo     | creditCardType   | month   | year | cvvNumber |
      | 1658947562034516 | Master Card      | October | 2022 |       685 |
      | 1658947562096516 | American Express | October | 2022 |       674 |
      | 1658947822034516 | VISA             | October | 2022 |       665 |
    Then User should verify after enter booking details success message "Booking Confirmation" and save the Order Id

    Examples: 
      | userName   | password  | location | hotels      | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childernPerRoom | firstName | lastName | billingAddress |
      | nivak12345 | 123456789 | London   | Hotel Creek | Double   | 1 - One   | 24/02/2023  | 25/02/2023   | 1 - One       | 2 - Two         | kavin     | Kumar    | Namakkal       |

  Scenario Outline: Verifying Adachin Select Hotel without enter Booking Details
    Given User is on the adachin page
    When User perform login "<userName>","<password>"
    Then User should verify after login sucess message "Hello nivak12345!"
    When User select search hotel "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childernPerRoom>"
    Then User should verify after search to navigate select hotel sucess message "Select Hotel"
    When User perform continue with select hotel name
    Then User should verify after continue to navigate Book a hotel with success message "Book A Hotel"
    When User click book now button without enter booking details
    Then User should verify after click book now button error message contains "Please Enter your First Name","Please Enter you Last Name","Please Enter your Address","Please Enter your 16 Digit Credit Card Number","Please Select your Credit Card Type","Please Select your Credit Card Expiry Month" and "Please Enter your Credit Card CVV Number"

    Examples: 
      | userName   | password  | location | hotels      | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childernPerRoom |
      | nivak12345 | 123456789 | London   | Hotel Creek | Double   | 1 - One   | 24/02/2023  | 25/02/2023   | 1 - One       | 2 - Two         |
