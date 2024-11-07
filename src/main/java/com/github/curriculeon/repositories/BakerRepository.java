package com.github.curriculeon.repositories;

import com.github.curriculeon.models.Baker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BakerRepository extends CrudRepository<Baker, Long> {
}
