package org.virtualization.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.virtualization.entity.Group

interface GroupRepository: JpaRepository<Group, Long> {
}