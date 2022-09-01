Feature: Create New Opporturnity without Mandatory Fields in SalesForce

Background: Login into SalesForce Application
Given Login using username and password
|userName|password|
|shobanasin.92@gmail.com|Maanve@18|
And Click on toggle menu button from the left corner
And Click view All link

@smoke
Scenario: Create New Opportunity without Mandatory Fields
Given click Sales from App Launcher
And Click on Opportunity tab
And Click on New button
And Choose Close date as Tomorrow Date
And Click on save and Verify the Alert message displayed