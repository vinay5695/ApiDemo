package RestAssuredTests;
import io.restassured.response.Response;

public class Util {
	
	
    String baseurl;
	int statuscode; 
	String statusline;
	
	public Util(boolean positive)
	{
		baseurl="http://reqres.in";
		if(positive)
		{
		this.statuscode=200;
		this.statusline ="HTTP/1.1 200 OK";
		}
		else
		{
			this.statuscode=404;
			this.statusline ="HTTP/1.1 404 Not Found";
		}
		
	}
	
	
	
	public boolean jsonStringComparison(Response response, String value)
	{
		String jsonstring = response.asString();
		if(jsonstring.contains(value))
		{
			return true;
		}
		return false;

	}
	

}
