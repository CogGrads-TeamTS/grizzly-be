package com.ts.grizzlybe.Service;


import com.ts.grizzlybe.Model.Category;
import com.ts.grizzlybe.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository;

    @Autowired
    public void PersonServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Page<Category> listAllByPage(Pageable pageable) {
       return  categoryRepository.findAll(pageable);
    }
}
