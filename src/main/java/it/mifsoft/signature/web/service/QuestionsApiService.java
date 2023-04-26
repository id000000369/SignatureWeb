package it.mifsoft.signature.web.service;

import org.springframework.web.reactive.function.client.WebClient;

public class QuestionsApiService extends AbstractApiService implements ApiService {
    public QuestionsApiService(String controllerName, WebClient webClient) {
        super(controllerName, webClient);
    }
}
