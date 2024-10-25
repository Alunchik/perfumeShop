package org.virtualization.controller;

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.virtualization.entity.Brand
import org.virtualization.repository.BrandRepository
import kotlin.math.log

@RestController()
@RequestMapping("/brand")
public class BrandController {
    val brandRepository: BrandRepository;

    @Autowired
    constructor(brandRepository: BrandRepository){
        this.brandRepository=brandRepository
    }

    @GetMapping("/")
    fun getAllBrands(): Iterable<Brand>{
        return brandRepository.findAll();
    }
    @DeleteMapping("/{id}")
    fun deleteBrand(@PathVariable id: Long): Unit{
        return brandRepository.deleteById(id)
    }
    @PostMapping("/")
    fun addBrand(@RequestBody brand: Brand): Brand {
        return brandRepository.save(brand)
    }
    @PostMapping("/{id}")
    fun updateBrand(@PathVariable id: Long, brand: Brand): Brand {
        brand.id=id
        return brandRepository.save(brand)
    }
}
