Feature: Create New Dashboard in SalesForce

Background: Login into SalesForce Application
Given Login using username and password
|userName|password|
|shobanasin.92@gmail.com|Maanve@18|
And Click on toggle menu button from the left corner
And Click view All link

@sanity
Scenario: Create New Dashboard
Given Click Dashboards from App Launcher
And Click on the New Dashboard option
And Enter Name as <name>
And Click on Create
And Click on Save
And Verify Dashboard name

Examples:
|name|
|Salesforce Automation by Shobana|