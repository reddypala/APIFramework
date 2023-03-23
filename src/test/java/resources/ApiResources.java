package resources;

//enum is a special class in java which is a collection of constants or methods

public enum ApiResources {
	
	//method declaration in enum methodName(parameters),methodName1(parameters),....
	//seperate methods by comma because enum treats all methods as one collection.
	
	AddPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json");
	
	private String resource;
	
	ApiResources(String resource){
		this.resource = resource;
	}
	
	public String getResource() {
		
		return resource;
	}
}
