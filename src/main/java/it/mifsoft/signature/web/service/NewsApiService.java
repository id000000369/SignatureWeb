package it.mifsoft.signature.web.service;

import org.springframework.web.reactive.function.client.WebClient;

public class NewsApiService extends AbstractApiService implements ApiService {
    public NewsApiService(String controllerName, WebClient webClient) {
        super(controllerName, webClient);
    }
}
