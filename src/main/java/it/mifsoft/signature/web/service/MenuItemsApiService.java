package it.mifsoft.signature.web.service;

import it.mifsoft.signature.web.dto.DishData;
import it.mifsoft.signature.web.dto.MenuCategoryData;
import it.mifsoft.signature.web.dto.PageData;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuItemsApiService extends AbstractApiService implements ApiService {
    public MenuItemsApiService(String controllerName, WebClient webClient) {
        super(controllerName, webClient);
    }

    public Mono<List<DishData>> getDishesByCategoryId(long categoryId) {
        ParameterizedTypeReference<PageData<DishData>> typeReference
                = new ParameterizedTypeReference<>(){};

        final Map<String, String> requestParams = new HashMap<>(getInfinityPageUriParams());
        requestParams.put("category", String.valueOf(categoryId));

        return webClient
                .get()
                .uri("/", requestParams)
                .retrieve()
                .bodyToMono(typeReference)
                .flatMap(page -> Mono.just(page.getResults()));
    }
}
