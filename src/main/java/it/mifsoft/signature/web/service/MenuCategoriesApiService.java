package it.mifsoft.signature.web.service;

import it.mifsoft.signature.web.dto.MenuCategoryData;
import it.mifsoft.signature.web.dto.PageData;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

public class MenuCategoriesApiService extends AbstractApiService implements ApiService {

    public MenuCategoriesApiService(String controllerName, WebClient webClient) {
        super(controllerName, webClient);
    }

    public Mono<List<MenuCategoryData>> getAll() {
        ParameterizedTypeReference<PageData<MenuCategoryData>> typeReference
                = new ParameterizedTypeReference<>(){};

        return webClient
                .get()
                .uri("/", getInfinityPageUriParams())
                .retrieve()
                .bodyToMono(typeReference)
                .flatMap(page -> Mono.just(page.getResults()));
    }
}
