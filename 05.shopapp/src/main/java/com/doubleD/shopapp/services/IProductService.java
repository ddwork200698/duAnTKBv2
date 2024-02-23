package com.doubleD.shopapp.services;

import com.doubleD.shopapp.DTO.ProductDTO;
import com.doubleD.shopapp.DTO.ProductImagesDTO;
import com.doubleD.shopapp.Exceptions.DataNotFoundExcepsiton;
import com.doubleD.shopapp.Exceptions.InvalidParamException;
import com.doubleD.shopapp.models.Product;
import com.doubleD.shopapp.models.ProductImage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface IProductService {
    public Product createProduct (ProductDTO productDto) throws DataNotFoundExcepsiton;
    public Product getProductById(Long id) throws DataNotFoundExcepsiton;

//    Page<Product> getAllProducts(java.awt.print.Pageable pageable);

    void deleteProduct(Long id);
    public Product updateProduct(Long id, ProductDTO productDTO) throws DataNotFoundExcepsiton;
    boolean existsByName(String name);

    ProductImage createProductImages(
            Long productId,
            ProductImagesDTO productImagesDTO) throws DataNotFoundExcepsiton, InvalidParamException;
}
