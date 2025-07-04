package org.example.productcatalogueservice.clients;

import jakarta.annotation.Nullable;
import org.example.productcatalogueservice.dtos.FakeStoreProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class FakeStoreApiClient {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductDto getFakeStoreProduct(Long id) {
        ResponseEntity<FakeStoreProductDto> response =
                requestForEntity(
                        HttpMethod.GET,
                        "https://fakestoreapi.com/products/{id}",
                        null,
                        FakeStoreProductDto.class,
                        id
                );

        if (validateResponse(response)) {
            return response.getBody();
        }
        return null;
    }

    public FakeStoreProductDto createFakeStoreProduct(FakeStoreProductDto fakeStoreProductDtoInput) {
        ResponseEntity<FakeStoreProductDto> response =
                requestForEntity(
                        HttpMethod.POST,
                        "https://fakestoreapi.com/products",
                        fakeStoreProductDtoInput,
                        FakeStoreProductDto.class
                );

        if (validateResponse(response)) {
            return response.getBody();
        }
        return null;
    }

    public FakeStoreProductDto replaceFakeStoreProduct(FakeStoreProductDto fakeStoreProductDtoInput, Long id) {
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity =
                requestForEntity(HttpMethod.PUT,"https://fakestoreapi.com/products/{id}",fakeStoreProductDtoInput,
                        FakeStoreProductDto.class,id);

        FakeStoreProductDto fakeStoreProductDtoOutput = fakeStoreProductDtoResponseEntity.getBody();

        if(validateResponse(fakeStoreProductDtoResponseEntity)) {
            return fakeStoreProductDtoOutput;
        }

        return null;
    }

    public List<FakeStoreProductDto> getAllFakeStoreProducts() {
        ResponseEntity<FakeStoreProductDto[]> response =
                requestForEntity(
                        HttpMethod.GET,
                        "https://fakestoreapi.com/products",
                        null,
                        FakeStoreProductDto[].class
                );

        if (response.getStatusCode() == HttpStatus.valueOf(200) && response.getBody() != null) {
            return Arrays.asList(response.getBody());
        }
        return Collections.emptyList();
    }


    private Boolean validateResponse(ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity) {
        if(fakeStoreProductDtoResponseEntity.getBody() != null &&
                fakeStoreProductDtoResponseEntity.getStatusCode() ==
                        HttpStatus.valueOf(200)) {

            return true;
        }

        return false;
    }

    private <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod, String url, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }
}
