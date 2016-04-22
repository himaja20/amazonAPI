package amazonAPITest;

import java.io.FileWriter;
import java.io.IOException;

import com.ECS.client.jax.Item;
import com.ECS.client.jax.Items;
import com.opencsv.CSVWriter;

public class Sample {

  public static void main(String[] args) throws IOException {
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

    CSVWriter writer = new CSVWriter(new FileWriter("phones.tsv"), '\t');
    for (Items itemList : response.getItems()) {
      for (Item item : itemList.getItem()){
        String[] entries = new String[2];
        entries[0] = item.getASIN();
        entries[1] = item.getItemAttributes().getTitle();
        writer.writeNext(entries);
      }
    }
    writer.close();

  }

}
