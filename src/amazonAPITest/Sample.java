package amazonAPITest;

import com.ECS.client.jax.Item;
import com.ECS.client.jax.Items;

public class Sample {

  public static void main(String[] args) {
    // Set the service:
    com.ECS.client.jax.AWSECommerceService service = new com.ECS.client.jax.AWSECommerceService();
    service.setHandlerResolver(new AwsHandlerResolver("6f7Etc5YDB3KrUsTcj5t95qHMOeo4P6IlffiJ5ba"));
    

    //Set the service port:
    com.ECS.client.jax.AWSECommerceServicePortType port = service.getAWSECommerceServicePort();

    //Get the operation object:
    com.ECS.client.jax.ItemSearchRequest itemRequest = new com.ECS.client.jax.ItemSearchRequest();

    itemRequest.setSearchIndex("Electronics");
    itemRequest.setKeywords("phone");
    itemRequest.setBrand("Samsung");

    com.ECS.client.jax.ItemSearch ItemElement= new com.ECS.client.jax.ItemSearch();
    ItemElement.setAWSAccessKeyId("AKIAJMUGVZL3BS26E3JQ");
    ItemElement.getRequest().add(itemRequest);
    ItemElement.setAssociateTag("ajr-20");
    
    //Call the Web service operation and store the response
    //in the response object:
    com.ECS.client.jax.ItemSearchResponse
        response = port.itemSearch(ItemElement);
    
    for (Items itemList : response.getItems()) {
      for (Item item : itemList.getItem()){
          System.out.println("Phone Name: " +
          item.getASIN() + " " + item.getItemAttributes().getTitle());
      }
  }

  }

}
