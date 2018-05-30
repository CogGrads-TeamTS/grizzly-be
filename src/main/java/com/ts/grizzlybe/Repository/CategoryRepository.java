package com.ts.grizzlybe.Repository;

import com.ts.grizzlybe.Model.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface CategoryRepository extends CrudRepository<Category, Long>,PagingAndSortingRepository<Category, Long> {

    //String sql = "select * from Category";
    @Query("select id,name,description from Category order by name asc")
    List<Category> sortByA_Z(String A_Z);

    @Query("select  id,name,description from Category order by name desc")
    List<Category> sortByZ_A(String Z_A);

    @Query("select id,name,description from Category order by id asc")
    List<Category> sortByIdAsc(String IdAsc);

    @Query("select id,name,description from Category order by id desc")
    List<Category> sortByIdDesc(String IdDesc);
}

