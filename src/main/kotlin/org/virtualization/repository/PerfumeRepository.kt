package org.virtualization.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.virtualization.entity.Brand
import org.virtualization.entity.Group
import org.virtualization.entity.Perfume

interface PerfumeRepository: JpaRepository<Perfume, Long> {
    fun findAllByBrand(brand: Brand): Iterable<Perfume>
    fun findAllByGroups(group: Group): Iterable<Perfume>
}