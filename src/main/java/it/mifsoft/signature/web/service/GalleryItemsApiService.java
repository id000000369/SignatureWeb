package it.mifsoft.signature.web.service;

import org.springframework.web.reactive.function.client.WebClient;

public class GalleryItemsApiService extends AbstractApiService implements ApiService {
    public GalleryItemsApiService(String controllerName, WebClient webClient) {
        super(controllerName, webClient);
    }
}
