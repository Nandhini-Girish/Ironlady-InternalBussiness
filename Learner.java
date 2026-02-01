package com.ironlady.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "learners")
public class Learner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String program;
    private String status;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getProgram() { return program; }
    public void setProgram(String program) { this.program = program; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
