Feature: Login

	Scenario: Invalid login scenario
		Given a user is at the login page
		When the user enters incorrect username or password
		Then the system should show an error message saying "Invalid username/password"