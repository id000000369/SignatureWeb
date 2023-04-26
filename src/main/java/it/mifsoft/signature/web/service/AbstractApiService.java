package it.mifsoft.signature.web.service;

import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractApiService implements ApiService {
    protected final String controllerName;
    protected final WebClient webClient;

    protected AbstractApiService(String controllerName, WebClient webClient) {
        this.controllerName = controllerName;
        this.webClient = webClient;
    }

    @Override
    public String getControllerName() {
        return controllerName;
    }

    @Override
    public WebClient getWebClient() {
        return webClient;
    }

    protected final Map<String, String> getInfinityPageUriParams() {
        return Map.of(
                "limit", "10000",
                "offset", "0"
        );
    }
}
