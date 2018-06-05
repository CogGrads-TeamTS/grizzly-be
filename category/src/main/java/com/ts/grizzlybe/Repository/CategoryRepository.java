package com.ts.grizzlybe.Repository;

import com.ts.grizzlybe.Model.Category;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Pageable;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface CategoryRepository extends CrudRepository<Category, Long>,PagingAndSortingRepository<Category, Long> {



    @Query("SELECT c FROM Category c WHERE " +
            "LOWER(c.name) LIKE LOWER(CONCAT('%',:search, '%')) OR " +
            "LOWER(c.description) LIKE LOWER(CONCAT('%',:search, '%'))")

    Page<Category> findBySearchTerm(@Param("search") String searchTerm, Pageable pageable);

    //String sql = "select * from Category";
     /*@Query("select c from Category c order by c.name asc")
    List<Category> sortByA_Z(String A_Z);

    @Query("select  c from Category c order by c.name desc")
    List<Category> sortByZ_A(String Z_A);

    @Query("select c from Category c order by c.id asc")
    List<Category> sortByIdAsc(String IdAsc);

    @Query("select c from Category c order by c.id desc")
    List<Category> sortByIdDesc(String IdDesc); */

}
