package com.utad.Simpsons.repository;

import com.utad.Simpsons.model.Simpson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimpsonRepository extends JpaRepository<Simpson, Long> {

}
