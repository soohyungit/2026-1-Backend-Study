//package com.example.shop.product;
//
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class ProductService {
//    private final ProductRepository productRepository;
//
//    public Long createProduct(ProductCreateRequest request){
//        Product existingProduct = productRepository.findByName(request.getName());
//        if(existingProduct != null){
//            throw new RuntimeException("이미 존재하는 상품입니다: "+ request.getName());
//        }
//
//
//        Product product = new Product(
//            request.getName(),
//            request.getPrice()
//        );
//
//        productRepository.save(product);
//
//        return product.getId();
//    }
//
//
//    public List<Product> getAllProducts(){
//        return productRepository.findAll();
//    }
//
//
//    public Product getProductById(Long id){
//        Product product = productRepository.findById(id);
//
//        if(product == null){
//            throw new RuntimeException("상품을 찾을 수 없습니다.");
//        }
//        return product;
//    }
//
//    public void updateProduct(Long id, ProductUpdateRequest request){
//        Product product = productRepository.findById(id);
//        if(product == null){
//            throw new RuntimeException("상품을 찾을 수 없습니다.");
//        }
//        product.updateInfo(request.getName(),request.getPrice() );
//    }
//
//    public void deleteProduct(Long id){
//        Product product = productRepository.findById(id);
//
//        if(product == null){
//            throw new RuntimeException("상품을 찾을 수 없습니다");
//        }
//
//        productRepository.deleteById(id);
//    }
//}
