package com.github.curriculeon.repositories;

import com.github.curriculeon.models.Muffin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

@Repository
public interface MuffinRepository extends CrudRepository<Muffin, Long> {
}
