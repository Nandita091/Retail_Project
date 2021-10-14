Feature: LoginUser

Background:
Given user is on  login page

Scenario Outline: Correct user login
When user enters correct "<email>" and "<password>" and clicks login
Then User homepage should be loaded successfully

Examples:
|email|password|
|mahfooza701@gmail.com|Mahfooza1|
|wrongmail@gmail.com|wrongPass1|


#Scenario:Search
#When user enters correct credentials and clicks login
#Then Admin homepage should be loaded successfully
#And user gives search for a word
#|item1 |
#And clicks search button
#Then Search result should be seen
