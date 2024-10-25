package org.virtualization

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
class VirtualizationApplication

fun main(args: Array<String>) {
	runApplication<VirtualizationApplication>(*args)
}
