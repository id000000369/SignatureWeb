package it.mifsoft.signature.web.service;

import org.springframework.web.reactive.function.client.WebClient;

public class LoginApiService extends AbstractApiService implements ApiService{
    public LoginApiService(String controllerName, WebClient webClient) {
        super(controllerName, webClient);
    }
}
