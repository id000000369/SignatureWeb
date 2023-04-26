package it.mifsoft.signature.web.service;

import org.springframework.web.reactive.function.client.WebClient;

public interface ApiService {
    String getControllerName();
    WebClient getWebClient();
}
