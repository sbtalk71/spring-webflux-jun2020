package clients;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import com.demo.spring.entity.Emp;

import reactor.core.publisher.Hooks;

public class MyReactiveRestClient {

	public static void main(String[] args) throws Exception{
		Hooks.onOperatorDebug();
		WebClient client=WebClient.create();
		
		client.get()
				.uri("http://localhost:8080/emp1/find/1022")
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(Emp.class)
				.subscribe(data->System.out.println(data));

		
		/*
		 * client.get() .uri("http://localhost:8080/emp1/all")
		 * .accept(MediaType.APPLICATION_JSON) .retrieve() .bodyToFlux(Emp.class)
		 * .subscribe(data->System.out.println(data));
		 */
		
		Thread.sleep(10000);
	}

}
