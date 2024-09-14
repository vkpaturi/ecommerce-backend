package com.project.spring.ecommercebackend.services;

import com.project.spring.ecommercebackend.dtos.FakeStoreDTO;
import com.project.spring.ecommercebackend.exceptions.ProductNotFoundException;
import com.project.spring.ecommercebackend.models.Category;
import com.project.spring.ecommercebackend.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    private final RestTemplate restTemplate;

    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long id) throws ProductNotFoundException {
        FakeStoreDTO responseDTO = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreDTO.class);
        if (responseDTO == null) {
            throw new ProductNotFoundException("Product not found at id " + id );
        }
        return convertDTOToObject(responseDTO);
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        FakeStoreDTO[] responseDTO = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreDTO[].class);
        assert responseDTO != null;
        for (FakeStoreDTO object : responseDTO) {
            products.add(convertDTOToObject(object));
        }
        return products;
    }

    @Override
    public Product addProduct(Product product) { // Remove convertDTOToObject and just send fakeStoreResponseDTO for FakeStore like response.
        FakeStoreDTO responseDTO = convertObjectToDTO(product);
        FakeStoreDTO fakeStoreResponseDTO = restTemplate.postForObject("https://fakestoreapi.com/products", responseDTO, FakeStoreDTO.class);
        assert fakeStoreResponseDTO != null;
        return convertDTOToObject(fakeStoreResponseDTO);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        FakeStoreDTO request = convertObjectToDTO(product);
        FakeStoreDTO fakeStoreResponseDTO = restTemplate.patchForObject("https://fakestoreapi.com/products/" + id, request, FakeStoreDTO.class);
        assert fakeStoreResponseDTO != null;
        return convertDTOToObject(fakeStoreResponseDTO);
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        FakeStoreDTO request = convertObjectToDTO(product);
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, FakeStoreDTO.class);
        HttpMessageConverterExtractor<FakeStoreDTO> responseExtractor =
                new HttpMessageConverterExtractor<>(FakeStoreDTO.class, restTemplate.getMessageConverters());
        FakeStoreDTO response =  restTemplate.execute("https://fakestoreapi.com/products/" + id, HttpMethod.PUT, requestCallback, responseExtractor);
        assert response != null;
        return convertDTOToObject(response);
    }

    @Override
    public String deleteProduct(Long id) {
//        RequestCallback requestCallback = restTemplate.httpEntityCallback(null, FakeStoreDTO.class);
       HttpMessageConverterExtractor<FakeStoreDTO> responseExtractor =
                new HttpMessageConverterExtractor<>(FakeStoreDTO.class, restTemplate.getMessageConverters());
        FakeStoreDTO response =  restTemplate.execute("https://fakestoreapi.com/products/" + id, HttpMethod.DELETE, null, responseExtractor);
        assert response != null;
        //return convertDTOToObject(response);
        return "";
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return List.of();
    }


    // Utility Methods
    public Product convertDTOToObject(FakeStoreDTO responseDTO) {
        Product product = new Product();
        product.setId(responseDTO.getId());
        product.setTitle(responseDTO.getTitle());
        product.setDescription(responseDTO.getDescription());
        product.setPrice(responseDTO.getPrice());
        product.setImageUrl(responseDTO.getImage());
        product.setCategory(new Category());
        product.getCategory().setName(responseDTO.getCategory());

        return product;
    }

    public FakeStoreDTO convertObjectToDTO(Product product) {
        FakeStoreDTO fakeStoreResponseDTO = new FakeStoreDTO();
        fakeStoreResponseDTO.setTitle(product.getTitle());
        fakeStoreResponseDTO.setDescription(product.getDescription());
        fakeStoreResponseDTO.setPrice(product.getPrice());
        fakeStoreResponseDTO.setImage(product.getImageUrl());
        fakeStoreResponseDTO.setCategory(product.getCategory().getName());

        return fakeStoreResponseDTO;
    }
}
