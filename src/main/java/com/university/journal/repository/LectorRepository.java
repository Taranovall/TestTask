package com.university.journal.repository;

import com.university.journal.entity.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectorRepository extends JpaRepository<Lector, Long> {

    List<Lector> findLectorByFirstNameOrLastNameContainingIgnoreCase(String firstName, String secondName);
}
