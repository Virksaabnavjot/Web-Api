package navsingh.org.uk.tcclient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 *
 * @author Navjot Singh
 */
public class GetClient {
    public static void main(String []args){
        int port = 8080;
        String getURL = "http://localhost:" + port + "/api/tc/temperature";
        Client client = Client.create();
        WebResource target = client.resource(getURL);
        
        ClientResponse response = target.queryParam("celsius","32").get(ClientResponse.class);
        System.out.println(response.getEntity(String.class));
        
    }
}
