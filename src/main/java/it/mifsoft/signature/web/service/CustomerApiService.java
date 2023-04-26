package it.mifsoft.signature.web.service;

import org.springframework.web.reactive.function.client.WebClient;

public class CustomerApiService extends AbstractApiService implements ApiService {
    public CustomerApiService(String controllerName, WebClient webClient) {
        super(controllerName, webClient);
    }
}
