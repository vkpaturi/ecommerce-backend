package com.project.spring.ecommercebackend.services;

import com.project.spring.ecommercebackend.dtos.FakeStoreResponseDTO;
import com.project.spring.ecommercebackend.models.Category;
import com.project.spring.ecommercebackend.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long id) {
        FakeStoreResponseDTO responseDTO = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreResponseDTO.class);
        assert responseDTO != null;
        return convertDTOToObject(responseDTO);
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        FakeStoreResponseDTO[] responseDTO = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreResponseDTO[].class);
        for (FakeStoreResponseDTO object : responseDTO) {
            products.add(convertDTOToObject(object));
        }
        return products;
    }



    // Utility Methods
    public Product convertDTOToObject(FakeStoreResponseDTO responseDTO) {
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
}
