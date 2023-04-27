package it.mifsoft.signature.web.service;

import it.mifsoft.signature.web.dto.GalleryItemsData;
import it.mifsoft.signature.web.dto.PageData;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GalleryItemsApiService extends AbstractApiService implements ApiService {
    public GalleryItemsApiService(String controllerName, WebClient webClient) {
        super(controllerName, webClient);
    }

    public Mono<List<GalleryItemsData>> getAllByGalleryId(long galleryId) {
        ParameterizedTypeReference<PageData<GalleryItemsData>> responseTypeReference = new ParameterizedTypeReference<>() {};

        final Map<String, String> requestParams = new HashMap<>(getInfinityPageUriParams());
        requestParams.put("gallery", String.valueOf(galleryId));
        return webClient
                .get()
                .uri("/", requestParams)
                .retrieve()
                .bodyToMono(responseTypeReference)
                .flatMap(page -> Mono.just(page.getResults()));
    }
}
