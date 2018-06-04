package com.ts.vendor.Service;

import com.ts.vendor.Model.Vendor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VendorService {

    Page<Vendor> findBySearchTerm(String searchTerm, Pageable pageable);
}
