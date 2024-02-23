package com.doubleD.shopapp.services;

import com.doubleD.shopapp.DTO.ProductDTO;
import com.doubleD.shopapp.DTO.ProductImagesDTO;
import com.doubleD.shopapp.Exceptions.DataNotFoundExcepsiton;
import com.doubleD.shopapp.Exceptions.InvalidParamException;
import com.doubleD.shopapp.models.Category;
import com.doubleD.shopapp.models.Product;
import com.doubleD.shopapp.models.ProductImage;
import com.doubleD.shopapp.repositories.CategoryRepo;
import com.doubleD.shopapp.repositories.ProductImageRepo;
import com.doubleD.shopapp.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.Optional;

@Service
public class ProductService implements IProductService{
    @Autowired
    ProductRepo productRepo;
    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    ProductImageRepo productImageRepo;
    @Override
    public Product createProduct(ProductDTO productDto) throws DataNotFoundExcepsiton {
        Category existingCategory = categoryRepo.findById(productDto.getCategoryId())
                .orElseThrow(()-> new DataNotFoundExcepsiton("Cannot find category with id: " + productDto.getCategoryId()));
        Product newProduct = Product.builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .thumbnail(productDto.getThumbnail())
                .category(existingCategory)
                .build();
        return productRepo.save(newProduct);
    }

    @Override
    public Product getProductById(Long productId) throws DataNotFoundExcepsiton {
        return productRepo.findById(productId)
                .orElseThrow(()-> new DataNotFoundExcepsiton("Cannot find Product with id "+ productId.toString()));
    }

//    @Override
//    public Page<Product> getAllProducts(Pageable pageable) {
//        // lay danh sach san pham theo page va limit
//
//        return productRepo.findAll(pageable);
//    }

    @Override
    public void deleteProduct(Long id) {
        Optional<Product> existingProduct = productRepo.findById(id);
        if (existingProduct.isPresent()){
            productRepo.deleteById(id);
        }
    }

    @Override
    public Product updateProduct(Long id, ProductDTO productDTO) throws DataNotFoundExcepsiton {
        Product existingProduct = getProductById(id);
        Category existingCategory = categoryRepo.findById(productDTO.getCategoryId())
                .orElseThrow(()-> new DataNotFoundExcepsiton("Cannot find category with id: " + productDTO.getCategoryId()));
        existingProduct = Product.builder()
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .thumbnail(productDTO.getThumbnail())
                .category(existingCategory)
                .build();
        return productRepo.save(existingProduct);
    }

    @Override
    public boolean existsByName(String name) {
        return productRepo.existsByName(name);
    }
    @Override
    public ProductImage createProductImages(
            Long productId,
            ProductImagesDTO productImagesDTO) throws DataNotFoundExcepsiton, InvalidParamException {
        Product existingProduct = productRepo.findById(productImagesDTO.getProductID())
                .orElseThrow(()-> new DataNotFoundExcepsiton("Cannot find category with id: " + productImagesDTO.getProductID()));
        ProductImage newProductImage = ProductImage.builder()
                .product(existingProduct)
                .url(productImagesDTO.getUrl())
                .build();
        // ko cho insert quá 5 ảnh cho một san phẩm
        int size = productImageRepo.findByProductId(productId).size();
        if(size >= 5){
            throw new InvalidParamException("Number of Image must be <= 5");
        }
        return productImageRepo.save(newProductImage);
    }
}
