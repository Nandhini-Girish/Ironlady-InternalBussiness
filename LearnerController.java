  package com.ironlady.controller;

import com.ironlady.entity.Learner;
import com.ironlady.repository.LearnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/learners")
@CrossOrigin("*")
public class LearnerController {

    @Autowired
    private LearnerRepository repo;

    // CREATE
    @PostMapping
    public Learner addLearner(@RequestBody Learner learner) {
        return repo.save(learner);
    }

    // READ
    @GetMapping
    public List<Learner> getAllLearners() {
        return repo.findAll();
    }

    // UPDATE
    @PutMapping("/{id}")
    public Learner updateLearner(@PathVariable Long id, @RequestBody Learner learner) {
        learner.setId(id);
        return repo.save(learner);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteLearner(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
