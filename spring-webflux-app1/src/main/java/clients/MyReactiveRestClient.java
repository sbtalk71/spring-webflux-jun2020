package clients;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

public class MyReactiveRestClient {

	public static void main(String[] args) throws Exception{
		
		WebClient client=WebClient.create();
		
		client.get()
				.uri("http://localhost:8080/rest/test/Scott")
				.accept(MediaType.TEXT_PLAIN)
				.exchange()
				.flatMap(data->data.bodyToMono(String.class)).subscribe(data->System.out.println(data));

		Thread.sleep(10000);
	}

}
