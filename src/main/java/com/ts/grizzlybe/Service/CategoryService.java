package com.ts.grizzlybe.Service;

import com.ts.grizzlybe.Model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
//    Page<Category> listAllByPage(Pageable pageable);

    Page<Category> findBySearchTerm(String searchTerm, Pageable pageable);
}
