package it.mifsoft.signature.web.service;

import org.springframework.web.reactive.function.client.WebClient;

public class GalleriesApiService extends AbstractApiService implements ApiService {
    public GalleriesApiService(String controllerName, WebClient webClient) {
        super(controllerName, webClient);
    }
}
