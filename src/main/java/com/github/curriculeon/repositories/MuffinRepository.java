package com.github.curriculeon.repositories;

import com.github.curriculeon.models.Muffin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MuffinRepository extends CrudRepository<Muffin, Long> {
}
