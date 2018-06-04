package com.ts.vendor.Controller;

import com.ts.vendor.Model.Vendor;
import com.ts.vendor.Repository.VendorRepository;
import com.ts.vendor.Service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/vendors")
@CrossOrigin
public class VendorController {
    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private VendorService vendorService;

    @GetMapping(value = "/page")
    public Page<Vendor> findBySearchTerm(@RequestParam("search") String searchTerm, Pageable pageable) {

        Page <Vendor> vendorPage = vendorService.findBySearchTerm(searchTerm, pageable);

        return vendorPage;
    }

    @GetMapping
    public @ResponseBody
    ResponseEntity<Iterable<Vendor>> getAllUsers() {
        Iterable<Vendor> categories = vendorRepository.findAll();
        // This returns a JSON or XML with the users

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
