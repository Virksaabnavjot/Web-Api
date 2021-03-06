package navsingh.org.uk.iphonetestproject;

import com.google.common.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.core.Response;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Navjot Virk
 */

@Path("iphone")
@Produces("application/json")
public class MyServiceFile {
    //Declaring the Arraylist to hold numbers
    List <Integer> list;
    
    //constructor
    public MyServiceFile(){
      list = new ArrayList<>();    
    }
    
    //Just a simple method to retun an arraylist with few numbers
    private List<Integer> getNumbers() {
        //adding numbers to arraylist
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        return list;
    }
    
    @GET //URL: http://localhost:8080/api/iphone
    public Response getAllMyNumbers(){
        list = getNumbers();
        //Convert Java to JSON
        Gson gson = new Gson();
        //build http resonse 200, What is an Entity ?
        return Response.status(200).entity(gson.toJson(list)).build();
    }
   
    @POST //URL: http://localhost:8080/api/iphone
    @Consumes("application/json")
    public Response post(String body){
        //declaring a arraylist
        List <Integer> list2 = new ArrayList<>();
        Gson gson = new Gson();
        // from JSON to Java object
        list2 = gson.fromJson(body, new TypeToken<List<Integer>>(){}.getType());
        list = getNumbers();
        list.addAll(list2);
        int sum = 0;
        for (Integer num : list2) {
            sum += num;
        }
  
        // Json is basically a map, so if we want to return a key and a value we can use a simple map
        Map<String, Integer> map = new HashMap<>();
        map.put("sum", sum);
        return Response.status(200).entity("Sum of your Numbers" +gson.toJson(map)+ " \nNew List of Numbers " +gson.toJson(list)).build();
    }
        
    @DELETE //Sample URL: http://localhost:8080/api/iphone/1
    @Path("{id}")
    public Response delete(@PathParam("id") int id){
        list = getNumbers();
        
        if(list.contains(id)){
            list.remove(list.indexOf(id));
            return Response.status(Response.Status.OK).entity("I deleted the number "+id+" from the list. \n Updated list " +list).build();
           }
        else{
            return Response.status(Response.Status.OK).entity("Number Not Found").build();
        }
       
    }
 
}
