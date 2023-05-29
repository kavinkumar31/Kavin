@CancelBooking
Feature: Verifying Adachin Hotel Cancel Booking Details

  Scenario Outline: Verifying Adachin Hotel Cancel booking
    Given User is on the adachin page
    When User perform login "<userName>","<password>"
    Then User should verify after login sucess message "Hello RamkumarT!"
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
    When User cancel the Order Id
    Then User should verify after cancel Order Id success message "The booking has been cancelled."

    Examples: 
      | userName   | password  | location | hotels      | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childernPerRoom | firstName | lastName | billingAddress |
      | nivak12345 | 123456789 | London   | Hotel Creek | Double   | 1 - One   | 24/02/2023  | 25/02/2023   | 1 - One       | 2 - Two         | kavin     | Kumar    | Namakkal       |

  Scenario Outline: Verifying Adachin hotel cancel booking for existing Order Id
    Given User is on the adachin page
    When User perform login "<userName>","<password>"
    Then User should verify after login sucess message "Hello RamkumarT!"
    When User cancel the existing "<OrderId>"
    Then User should verify after cancel Order Id success message "The booking has been cancelled."

    Examples: 
      | userName   | password  | OrderId    |
      | nivak12345 | 123456789 | 137960L287 |
