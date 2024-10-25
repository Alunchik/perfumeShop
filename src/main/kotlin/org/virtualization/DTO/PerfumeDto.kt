package org.virtualization.DTO

data class PerfumeDto(
        val name: String,
        val brandId: Long,
        val perfumeGroupIds: List<Long>
)