package com.ts.grizzlybe.Controller;

import com.ts.grizzlybe.Model.Category;
import com.ts.grizzlybe.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/categories")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping(path="/add") // Map ONLY GET Requests
    public String addNewCategory (@RequestParam String name, @RequestParam String description) {

        Category category = new Category();
        category.setName(name);
        category.setDescription(description);
        categoryRepository.save(category);

        return "Category saved";
    }

    @GetMapping
    public @ResponseBody Iterable<Category> getAllUsers() {
        // This returns a JSON or XML with the users
        return categoryRepository.findAll();
    }

}
