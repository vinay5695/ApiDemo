package RestAssuredTests;

import org.testng.Assert;

import org.testng.annotations.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;


public class RestAssuredDemotests {
	
	Util util= new Util(true);
	@BeforeClass
	public void commonutil()
	{
		RestAssured.baseURI=util.baseurl;
	}
	//used for testing
	@Test
	public void getSingleUser()
	{		
		RestAssured.basePath="/api/users/2";		
		Response response=
		given()
		.when()
		   .get()
		.then()
		   .statusCode(util.statuscode)
		   .statusLine(util.statusline)
		   .assertThat().body("data.id", equalTo(2))
		   .header("content-type", "application/json; charset=utf-8").extract().response();
		Assert.assertTrue(util.jsonStringComparison(response, "janet.weaver@reqres.in"));
	}
	//test command masi
	@Test
	public void getListUsers()
	{
		RestAssured.basePath="/api/users?page=1";
		given()
		.when()
		   .get()
		.then()
		   .statusCode(util.statuscode)
		   .statusLine(util.statusline)
		   .body("data.id", hasItems(1,2,3,4,5,6))
		   .header("content-type", "application/json; charset=utf-8").log().all();		
	}
	
	@Test
	public void getSingleUserNotFound()
	{
		util=new Util(false);
		RestAssured.basePath="/api/users/23";
		given()
		.when()
		   .get()
		.then()
		   .statusCode(util.statuscode)
		   .statusLine(util.statusline)
		   .header("content-type", "application/json; charset=utf-8");		
	}

	@Test
	public void getDelayedResponse()
	{
		RestAssured.basePath="/api/users?delay=3";
		given()
		.when()
		   .get()
		.then()
		   .statusCode(util.statuscode)
		   .statusLine(util.statusline)
		   .body("data.id", hasItems(1,2,3,4,5,6))
		   .header("content-type", "application/json; charset=utf-8");		
	}
	
	@Test
	public void getSingleResource()
	{
		RestAssured.basePath="/api/unknown/2";
		given()
		.when()
		   .get()
		.then()
		   .statusCode(util.statuscode)
		   .statusLine(util.statusline)
		   .body("data.color",equalTo("#C74375"))

		   .header("content-type", "application/json; charset=utf-8");		
	}
=======
		   .header("content-type", "application/json; charset=utf-8");	
		
	}

	
	@Test
	public void getDoubleleUser()
	{		
		RestAssured.basePath="/api/users/3";
		
		Response response=
=======
	@Test
	public void getSingleResource8()
	{
		RestAssured.basePath="/api/unknown/8";
>>>>>>> main
		given()
		.when()
		   .get()
		.then()
		   .statusCode(util.statuscode)
<<<<<<< HEAD
		   .statusLine(util.statusline)
		   .assertThat().body("data.id", equalTo(3))
		   .header("content-type", "application/json; charset=utf-8").extract().response();
		Assert.assertTrue(util.jsonStringComparison(response, "janet.weaver@reqres.in"));
//		String jsonstring=response.asString();
//		Assert.assertEquals(jsonstring.contains("janet.weaver@reqres.in"), true);
	}
	
//	@Test
//	public void sample()
//	{
//		given().when().get("https://dummy.restapiexample.com/api/v1/employees").then().statusCode(200).log().all();
//	}
//	
//	@Test
//	public void post()
//	{		
//		HashMap map=new HashMap();
//		map.put("name", "morpheus");
//		map.put("job", "leader");
////		map.forEach((k, v) -> {
////			System.out.println("Key: " + k + ", Value: " + v);
////		});
//		given().contentType("application/json; charset=utf-8").body(map).post("/api/users").then().statusCode(201);
//	}


=======
		   .header("content-type", "application/json; charset=utf-8");		
	}

}
