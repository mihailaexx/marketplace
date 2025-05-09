package org.example.marketplace.repository;

import org.example.marketplace.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.discount > 0")
    List<Product> findAllProductsWithDiscount();

    @Query("SELECT p FROM Product p WHERE p.discount = 0")
    List<Product> findAllProductsWithoutDiscount();

    @Query("SELECT p FROM Product p WHERE p.quantity > 0")
    List<Product> findProductsInStock();

    @Query("SELECT p FROM Product p WHERE p.discount = 0")
    List<Product> findProductsOutOfStock();


    List<Product> findProductsByCategoryId(long categoryId);

    @Query("SELECT cp.product FROM CartProduct cp WHERE cp.userCart.user.id = :userId")
    List<Product> findUserCartProducts(@Param("userId") long userId);

    @Query("SELECT lp.product FROM LikeProducts lp WHERE lp.userLike.user.id = :userId")
    List<Product> findUserLikedProducts(@Param("userId") long userId);

    @Query("SELECT op.product FROM OrderProducts op WHERE op.userOrder.user.id = :userId")
    List<Product> findUserBoughtProducts(@Param("userId") long userId);

    @Query("SELECT op.product FROM OrderProducts op WHERE op.userOrder.id = :orderId")
    List<Product> findOrderProductsByOrderId(@Param("orderId") long orderId);
}