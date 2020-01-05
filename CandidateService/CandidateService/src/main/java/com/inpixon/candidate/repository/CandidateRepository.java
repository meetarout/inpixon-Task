package com.inpixon.candidate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inpixon.candidate.entity.Candidate;


@Repository
public interface CandidateRepository extends JpaRepository<Candidate,Long> {
	
	
	@Query("SELECT coalesce(max(ch.id), 0) FROM Candidate ch")
	Long getMaxId();

}
