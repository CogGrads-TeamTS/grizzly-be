package com.ts.vendor.Service;

import com.ts.vendor.Model.Vendor;
import com.ts.vendor.Repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VendorServiceImpl implements VendorService{

    @Autowired
    private VendorRepository vendorRepository;

    public Page<Vendor> findBySearchTerm(String searchTerm, Pageable pageable){
        return vendorRepository.findBySearchTerm(searchTerm, pageable);
    }
}

