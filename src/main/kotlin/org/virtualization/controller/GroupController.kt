package org.virtualization.controller;

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.virtualization.entity.Group;
import org.virtualization.repository.GroupRepository

@RestController
@RequestMapping("/group")
public class GroupController {

    val groupRepository: GroupRepository;

    @Autowired constructor(groupRepository: GroupRepository){
        this.groupRepository=groupRepository
    }

    @GetMapping
    fun getAllGroups(): Iterable<Group>{
        return groupRepository.findAll();
    }
    @DeleteMapping("/{id}")
    fun deleteGrop(@PathVariable id: Long): Unit{
        return groupRepository.deleteById(id)
    }
    @PostMapping
    fun addGrop(@RequestBody group: Group): Group {
        groupRepository.save(group)
        return group
    }
    @PostMapping("/{id}")
    fun updateGrop(@PathVariable id: Long, @RequestBody  group: Group): Group{
        group.id=id
        return groupRepository.save(group)
    }
}
