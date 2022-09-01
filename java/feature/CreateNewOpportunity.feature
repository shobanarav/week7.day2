Feature: Create New Opporturnity in SalesForce

Background: Login into SalesForce Application
Given Login using username and password
|userName|password|
|shobanasin.92@gmail.com|Maanve@18|
And Click on toggle menu button from the left corner
And Click view All link

@sanity
Scenario: Create New Opportunity
Given Click Sales from App Launcher
And Click on Opportunity tab 
And Click on New button
When Enter Opportunity name as <opportunityname>
And Choose close date as Today
And Select Stage as <stagename>
Then Click Save and Verify Oppurtunity Name

Examples:
|opportunityname|stagename|
|Salesforce Automation by Shobana|Need Analysis|
