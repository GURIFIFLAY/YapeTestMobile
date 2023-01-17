Feature: Reserve accommodation in Cusco
  As a user
  I want to be able to reserve accommodation in Cusco
  So that I can plan my stay in the city
  @ExampleTag
  Scenario: Reserve a hotel room in Cusco
    Given I am on the booking website homepage
    When I search for available hotels in "Cusco"
    And I select the check-in date "14 February 2023" and check-out date "28 February 2023"
    And I select 1 room, 2 adults and 1 child of 5 years old
    And I choose the 1nd hotel from the search results
    And I select the 1 option of room type
    And I enter my personal info "Juan", "Munoz", "nhxu_tpeou65@pihey.com","Argentina","261654321"
    And I enter my card info "5165850000000008", "12/29", "123" and confirm the reservation
    Then I should see a confirmation page with the details of my reservation

  @ExampleTag
  Scenario: Unhappy Reserve a hotel room
    Given I am on the booking website homepage
    When I search for available hotels in "Cusco"
    And I select the check-in date "14 February 2023" and check-out date "28 February 2023"
    And I select 1 room, 2 adults and 1 child of 5 years old
    And I choose the 1nd hotel from the search results
    And I select the 1 option of room type
    And I dont enter my personal info
    Then I should see a alert with "Please enter your first name."

