package it.mifsoft.signature.web;

import it.mifsoft.signature.web.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class HttpClientConfiguration {

    public static final String BASE_URL = "http://167.172.181.127:8000/api/v1/";
    public static final String ANSWERS_CONTROLLER_NAME = "answers";
    public static final String CUSTOMER_CONTROLLER_NAME = "customer";
    public static final String GALLERIES_CONTROLLER_NAME = "galleries";
    public static final String GALLERY_ITEMS_CONTROLLER_NAME = "gallery_items";
    public static final String LOGIN_CONTROLLER_NAME = "login";
    public static final String MENU_CATEGORIES_CONTROLLER_NAME = "menu_categories";
    public static final String MENU_ITEMS_CONTROLLER_NAME = "menu_items";
    public static final String NEWS_CONTROLLER_NAME = "news";
    public static final String QUESTIONNAIRES_CONTROLLER_NAME = "questionnaires";
    public static final String QUESTIONS_CONTROLLER_NAME = "questions";

    @Bean
    public AnswersApiService answersApiService() {
        return new AnswersApiService(ANSWERS_CONTROLLER_NAME, webClient(ANSWERS_CONTROLLER_NAME));
    }

    @Bean
    public CustomerApiService customerApiService() {
        return new CustomerApiService(CUSTOMER_CONTROLLER_NAME, webClient(CUSTOMER_CONTROLLER_NAME));
    }

    @Bean
    public GalleriesApiService galleriesApiService() {
        return new GalleriesApiService(GALLERIES_CONTROLLER_NAME, webClient(CUSTOMER_CONTROLLER_NAME));
    }

    @Bean
    public GalleryItemsApiService galleryItemsApiService() {
        return new GalleryItemsApiService(GALLERY_ITEMS_CONTROLLER_NAME, webClient(GALLERY_ITEMS_CONTROLLER_NAME));
    }

    @Bean
    public LoginApiService loginApiService() {
        return new LoginApiService(LOGIN_CONTROLLER_NAME, webClient(LOGIN_CONTROLLER_NAME));
    }

    @Bean
    public MenuCategoriesApiService menuCategoriesApiService() {
        return new MenuCategoriesApiService(MENU_CATEGORIES_CONTROLLER_NAME, webClient(MENU_CATEGORIES_CONTROLLER_NAME));
    }

    @Bean
    public MenuItemsApiService menuItemsApiService() {
        return new MenuItemsApiService(MENU_ITEMS_CONTROLLER_NAME, webClient(MENU_ITEMS_CONTROLLER_NAME));
    }

    @Bean
    public NewsApiService newsApiService() {
        return new NewsApiService(NEWS_CONTROLLER_NAME, webClient(NEWS_CONTROLLER_NAME));
    }

    @Bean
    public QuestionnairesApiService questionnairesApiService() {
        return new QuestionnairesApiService(QUESTIONNAIRES_CONTROLLER_NAME, webClient(QUESTIONNAIRES_CONTROLLER_NAME));
    }

    @Bean
    public QuestionsApiService questionsApiService() {
        return new QuestionsApiService(QUESTIONS_CONTROLLER_NAME, webClient(QUESTIONS_CONTROLLER_NAME));
    }

    public WebClient webClient(String controllerName) {
        final WebClient.Builder builder = WebClient.builder();
        final WebClient webClient = builder
                .baseUrl(BASE_URL + controllerName)
                .defaultHeader("accept", "application/json")
                .build();
        return webClient;
    }
}
