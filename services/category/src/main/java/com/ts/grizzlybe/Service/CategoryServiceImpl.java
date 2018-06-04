package com.ts.grizzlybe.Service;


import com.ts.grizzlybe.Model.Category;
import com.ts.grizzlybe.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service // Marking this class as a service components
@Transactional
public class CategoryServiceImpl implements CategoryService{

    @Autowired // Autowire
    private CategoryRepository categoryRepository;

//    Not Required as category is being autowired above
//    @Autowired
//    public void PersonServiceImpl(CategoryRepository categoryRepository){
//        this.categoryRepository = categoryRepository;
//    }

//    @Override // Annotation not required but is good for readability. Not 100% necessary now that IDE's have linters
//    public Page<Category> listAllByPage(Pageable pageable) {
//       return  categoryRepository.findAll(pageable);
//    }

    public  Page<Category> findBySearchTerm(String searchTerm, Pageable pageable){
        return categoryRepository.findBySearchTerm(searchTerm, pageable);
    }
}