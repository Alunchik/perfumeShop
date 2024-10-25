package org.virtualization.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.virtualization.entity.Brand

interface BrandRepository: JpaRepository<Brand, Long> {
}