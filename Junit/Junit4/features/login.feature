Feature: Test of login funcionality

  Scenario: the user should be to able login correct with username and pass
    Given user is on login page
    When user enters correct credentials
    Then user get confirmed
    
	Scenario Outline: the user should able to login
		Given user is on login page
		When user enters user <username>
		And  user enters pass <password>
		Then user get confirmed
		
	Examples:
		| username | password |
		| admin | jhony12345 |
		| admin | 1234 |
		| admin | asdf |