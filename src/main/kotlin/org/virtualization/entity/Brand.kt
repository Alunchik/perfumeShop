package org.virtualization.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import org.hibernate.annotations.Cascade
import org.hibernate.annotations.CascadeType

@Entity
class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long?=null;
    var name: String?=null;
    var country: String?=null;
    @OneToMany(mappedBy = "brand")
    @Cascade(CascadeType.DELETE, CascadeType.DETACH)
    @JsonIgnore
    var perfumes: Set<Perfume>? = HashSet()
}