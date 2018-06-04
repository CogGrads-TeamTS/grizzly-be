package com.ts.grizzlybe.Service;

import com.ts.grizzlybe.Model.Category;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;


public interface CategoryService {
//    Page<Category> listAllByPage(Pageable pageable);
    @GetMapping(value = "/page")
    Page<Category> findBySearchTerm(String searchTerm, Pageable pageable);
}