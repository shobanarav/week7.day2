Feature: Create New Individuals in SalesForce

Background: Login into SalesForce Application
Given Login using username and password
|userName|password|
|shobanasin.92@gmail.com|Maanve@18|
And Click on toggle menu button from the left corner
And Click view All link

@smoke
Scenario: Create New Indiviual
Given Click Individuals from App Launcher
And Click on the Dropdown icon in the Individuals tab
And Click on New Individual 
And Enter the Last Name as <indiviualname>
Then Click save and verify Individuals Name


Examples:
|indiviualname|
|Kumar|