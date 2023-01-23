package com.university.journal.repository;

import com.university.journal.entity.HeadOfDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeadOfDepartmentRepository extends JpaRepository<HeadOfDepartment, Long> {

    List<HeadOfDepartment> findLectorByFirstNameOrLastNameContainingIgnoreCase(String firstName, String secondName);
}
