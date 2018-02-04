#Each feature file contains one feature.
#Feature files use Gherkin language which is a business language.
Feature: Test the Login functionality of SDET University

#A feature can have one or more sceanrios.
#Scenarios use Given-When-Then structure. 
Scenario: The user should be able to login with correct username and correct password
Given user is on login page
When user enters correct username and correct password
Then user gets confirmation

Scenario Outline: the user should be able to login
Given user is on login page
When user enters email <username>
And user enters password <password>
And user clicks login button
Then user gets confirmation

Examples:
| username | password |
| tim@testemail.com | trpass |
| sw@testemail.com | sw2password |
| jv@testemail.com | jv4password |