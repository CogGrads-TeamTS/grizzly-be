package com.ts.grizzlybe.Service;

import com.ts.grizzlybe.Model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    public Page<Category> listAllByPage(Pageable pageable);
}
