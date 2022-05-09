package com.nals.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nals.java.model.Work;

/**
 * 
 * @author Admin
 *
 */
@Repository
public interface WorkRepository extends JpaRepository<Work, Long> {

}
