package com.ts.grizzlybe.Controller;

import com.ts.grizzlybe.Model.Category;
import com.ts.grizzlybe.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/categories")
@CrossOrigin
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping(path="/add", headers = "Content-Type=application/json") // Map ONLY GET Requests
    public ResponseEntity addNewCategory (@RequestBody Category category) {

        categoryRepository.save(category);

        return new ResponseEntity<>("Category saved", HttpStatus.CREATED);
    }

    @PostMapping(path="/add") // Map ONLY GET Requests
    public ResponseEntity addNewCategory (@RequestParam String name, @RequestParam String description) {

        Category category = new Category();
        category.setName(name);
        category.setDescription(description);
        categoryRepository.save(category);

        return new ResponseEntity<>("Category saved", HttpStatus.CREATED);
    }

    @GetMapping
    public @ResponseBody ResponseEntity<Iterable<Category>> getAllUsers() {
        Iterable<Category> categories = categoryRepository.findAll();
        // This returns a JSON or XML with the users
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/load/{id}")
    public @ResponseBody ResponseEntity getCategory(@PathVariable long id)
    {
        Optional<Category> category =  categoryRepository.findById(id);
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else
        {
            return new ResponseEntity<>(category,HttpStatus.OK);
        }

    }

    @PutMapping("/edit/{id}")
    public ResponseEntity editCategory(@PathVariable long id ,@RequestBody Category category )
    {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (!categoryOptional.isPresent())
            return ResponseEntity.notFound().build();

        category.setId(id);

        categoryRepository.save(category);

       // return ResponseEntity.noContent().build();
        return new ResponseEntity<>("Category @{" + id + "} updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCategory(@PathVariable long id) {
        categoryRepository.deleteById(id);

        return new ResponseEntity<>("Deleted user@{" + id + "} successfully", HttpStatus.OK);
    }

}
