package org.virtualization.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.virtualization.DTO.PerfumeDto
import org.virtualization.entity.Perfume
import org.virtualization.repository.BrandRepository
import org.virtualization.repository.GroupRepository
import org.virtualization.repository.PerfumeRepository

@Service
class PerfumeService {
    val perfumeRepository: PerfumeRepository;
    val brandRepository: BrandRepository;
    val groupRepository: GroupRepository;

    @Autowired
    constructor(perfumeRepository: PerfumeRepository,
            groupRepository: GroupRepository,
            brandRepository: BrandRepository){
        this.perfumeRepository = perfumeRepository;
        this.groupRepository = groupRepository;
        this.brandRepository = brandRepository;
    }
    fun save(perfumeDto: PerfumeDto){
        val perfume = Perfume(
                name = perfumeDto.name,
                brand = brandRepository.findById(perfumeDto.brandId).orElse(null),
                groups = groupRepository.findAllById(perfumeDto.perfumeGroupIds).toHashSet())
        perfumeRepository.save(perfume)
    }
}