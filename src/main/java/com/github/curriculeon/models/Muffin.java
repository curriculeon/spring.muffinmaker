package com.github.curriculeon.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Muffin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String flavor;

    public Muffin() {
    }

    public Muffin(String flavor) {
        this.flavor = flavor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Muffin muffin = (Muffin) o;
        return Objects.equals(id, muffin.id) &&
                Objects.equals(flavor, muffin.flavor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, flavor);
    }
}
