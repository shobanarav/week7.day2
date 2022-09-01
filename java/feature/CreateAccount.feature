Feature: Create Accounts in SalesForce

Background: Login into SalesForce Application
Given Login using username and password
|userName|password|
|shobanasin.92@gmail.com|Maanve@18|
And Click on toggle menu button from the left corner
And Click view All link

@smoke
Scenario: Create Accounts
Given Click Sales from App Launcher
And Click on Accounts tab
And Click on New button
And Enter your name as <accountname>
And Select Ownership as Public
And Click save and verify Account name

Examples:
|accountname|
|Shobana|
|Maanve|
