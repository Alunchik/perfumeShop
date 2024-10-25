package org.virtualization.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
@Table(name="fGroup")
class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long?=null;
    var name: String?=null;
    var description: String?=null;
    @ManyToMany
    @JsonIgnore
    @JoinTable(name="perfume_fGroup",
            joinColumns = [JoinColumn(name = "fGroup_id", referencedColumnName = "id")],
            inverseJoinColumns = [JoinColumn(name = "perfume_id", referencedColumnName = "id")])
    var perfumes: Set<Perfume>?=null

}