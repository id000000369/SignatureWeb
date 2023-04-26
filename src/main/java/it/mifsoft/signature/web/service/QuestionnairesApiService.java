package it.mifsoft.signature.web.service;

import org.springframework.web.reactive.function.client.WebClient;

public class QuestionnairesApiService extends AbstractApiService implements ApiService {
    public QuestionnairesApiService(String controllerName, WebClient webClient) {
        super(controllerName, webClient);
    }
}
