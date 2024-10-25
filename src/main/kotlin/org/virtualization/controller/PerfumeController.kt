package org.virtualization.controller

import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.virtualization.DTO.PerfumeDto
import org.virtualization.entity.Brand
import org.virtualization.entity.Group
import org.virtualization.entity.Perfume
import org.virtualization.repository.PerfumeRepository
import org.virtualization.service.PerfumeService

@RestController
@Slf4j
class PerfumeController {

    val perfumeRepository: PerfumeRepository;
    val perfumeService: PerfumeService;

    @Autowired constructor(perfumeRepository: PerfumeRepository,
            perfumeService: PerfumeService){
        this.perfumeRepository = perfumeRepository;
        this.perfumeService = perfumeService;
    }

    @GetMapping("/perfume")
    fun getAllPerfumes(): Iterable<Perfume>{
        return perfumeRepository.findAll();
    }
    @GetMapping("/perfume/{id}")
    fun getPerfumeById(@PathVariable id: Long): Perfume?{
        return perfumeRepository.findById(id).get();
    }
    @GetMapping("/perfume/brand")
    fun getPerfumesByBrand(brand: Brand): Iterable<Perfume>{
        return perfumeRepository.findAllByBrand(brand);
    }
    @GetMapping("/perfume/group")
    fun getPerfumesByGroup(group: Group): Iterable<Perfume>{
        return perfumeRepository.findAllByGroups(group);
    }
    @DeleteMapping("/perfume/{id}")
    fun deletePerfumeById(@PathVariable id: Long): Unit{
        return perfumeRepository.deleteById(id)
    }
    @PutMapping("/prefume/{id}")
    fun updatePerfume(@PathVariable id: Long, perfume: Perfume): Perfume{
        perfume.id=id
        return perfumeRepository.save(perfume)
    }
    @PostMapping("/perfume")
    fun addPerfumeDto(@RequestBody perfumeDto: PerfumeDto): Iterable<Perfume>{
        perfumeService.save(perfumeDto)
        return perfumeRepository.findAll();
    }
//    @PostMapping("/perfume/new")
//    fun addPerfume(@RequestBody perfume: Perfume): Iterable<Perfume>{
//        perfumeRepository.save(perfume)
//        return perfumeRepository.findAll();
//    }
}