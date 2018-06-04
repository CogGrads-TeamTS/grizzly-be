package com.ts.vendor.Repository;

import com.ts.vendor.Model.Vendor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface VendorRepository extends CrudRepository<Vendor, Long>, PagingAndSortingRepository<Vendor, Long> {


    @Query("SELECT c FROM Vendor c WHERE " +
            "LOWER(c.name) LIKE LOWER(CONCAT('%',:search, '%')) OR " +
            "LOWER(c.contact) LIKE LOWER(CONCAT('%',:search, '%'))")

    Page<Vendor> findBySearchTerm(@Param("search") String searchTerm, Pageable pageable);
}
