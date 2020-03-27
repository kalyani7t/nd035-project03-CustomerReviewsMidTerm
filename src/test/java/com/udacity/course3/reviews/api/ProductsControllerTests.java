package com.udacity.course3.reviews.api;

import com.udacity.course3.reviews.enitty.Product;
import com.udacity.course3.reviews.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductsControllerTests {
    @Autowired
    private ProductRepository productRepository;

   @Test
    public void givenProductRepository_whenSaveAndRetrieveEntity_thenOK(){
        Product product = productRepository.save(getProduct());
        Product foundProduct = productRepository.findById(product.getId()).get();
        assertNotNull(foundProduct);
        assertEquals(product.getName(), foundProduct.getName());
   }

   private Product getProduct(){
       Product product = new Product();
       product.setName("Prestige Cooker");
       product.setDescription("Jo biwi se kare pyaar, wo Prestige se kaise kare inkaar?!");
       return product;
   }
}
