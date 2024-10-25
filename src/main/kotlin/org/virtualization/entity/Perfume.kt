package org.virtualization.entity

import jakarta.persistence.*
import org.hibernate.annotations.Cascade

@Entity
class Perfume {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    @Column(nullable = false)
    var name: String? = null

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    var brand: Brand? = null

    @ManyToMany
    @JoinTable(name = "perfume_fGroup",
            joinColumns = [JoinColumn(name = "perfume_id", referencedColumnName = "id")],
            inverseJoinColumns = [JoinColumn(name = "fGroup_id", referencedColumnName = "id")])
    var groups: Set<Group>? = null

    constructor(name: String, brand: Brand?, groups: Set<Group>?) {
        this.name = name;
        this.groups = groups;
        this.brand = brand;
    }
    constructor(id: Long, name: String, brand: Brand?, groups: Set<Group>?) {
        this.id = id
        this.name = name;
        this.groups = groups;
        this.brand = brand;
    }
}