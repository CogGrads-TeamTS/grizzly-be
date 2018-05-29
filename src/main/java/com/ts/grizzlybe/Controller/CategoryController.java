package com.ts.grizzlybe.Controller;

import com.ts.grizzlybe.Model.Category;
import com.ts.grizzlybe.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/categories")
@CrossOrigin
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
        Iterable<Category> categories = categoryRepository.findAll();
        // This returns a JSON or XML with the users
        return categories;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCategory(@PathVariable long id) {
        categoryRepository.deleteById(id);

        return new ResponseEntity<>("Deleted user@{" + id + "} successfully", HttpStatus.ACCEPTED);
    }

}
