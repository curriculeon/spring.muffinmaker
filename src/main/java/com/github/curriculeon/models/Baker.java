package com.github.curriculeon.models;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;
@Entity
public class Baker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String employeeId;

    private String specialty;

    public Baker() {
    }

    public Baker(String name, String employeeId, String specialty) {
        this(null, name, employeeId, specialty);
    }

    public Baker(Long id, String name, String employeeId, String specialty) {
        this.id = id;
        this.name = name;
        this.employeeId = employeeId;
        this.specialty = specialty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Baker baker = (Baker) o;
        return Objects.equals(id, baker.id) &&
                Objects.equals(name, baker.name) &&
                Objects.equals(employeeId, baker.employeeId) &&
                Objects.equals(specialty, baker.specialty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, employeeId, specialty);
    }
}
