Feature: validating place API's 

@addPlaceTag
Scenario Outline:: verify if place is being added successfully  using AddPlaceAPI 
	Given Add place payload with "<name>" "<language>" "<address>"
	When user calls "AddPlaceAPI" with "post" http request 
	Then the api call is success with status code 200 
	And "status" in response body is "OK" 
	And "scope" in response body is "APP"
	And verify placeId created maps to "<name>" using "getPlaceAPI"
Examples:
	| name | language | address |
	| ARHouse | English| world cross center|
	| AbcHouse | German | german cross center|
	| newManHouse| Telugu | sindhu cross center|

@deletePlaceTag
Scenario: verify if delete place functionality is working

	Given DeletePlace payload
	When user calls "deletePlaceAPI" with "post" http request
	Then the api call is success with status code 200
	And "status" in response body is "OK" 	