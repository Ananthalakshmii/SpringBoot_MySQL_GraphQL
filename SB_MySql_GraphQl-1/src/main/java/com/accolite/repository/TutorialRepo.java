package com.accolite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accolite.model.Tutorial;

public interface TutorialRepo extends JpaRepository<Tutorial,Long>{

}
