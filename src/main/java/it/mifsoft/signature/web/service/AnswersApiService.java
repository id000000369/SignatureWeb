package it.mifsoft.signature.web.service;

import org.springframework.web.reactive.function.client.WebClient;

public class AnswersApiService extends AbstractApiService implements ApiService {
    public AnswersApiService(String controllerName, WebClient webClient) {
        super(controllerName, webClient);
    }
}
