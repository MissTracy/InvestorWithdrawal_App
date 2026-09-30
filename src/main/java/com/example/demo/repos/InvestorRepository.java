package com.example.demo.repos;
/**
 * The Repo interface provides database operations such as
 * saving, retrieving, updating, and deleting data.
 *
 * Spring Data JPA automatically provides the implementation
 * and can generate queries based on method names, allowing
 * the application to interact with the database without
 * writing SQL for common operations.
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Models.Investor;


//perform database operations and configure the database connection
@Repository
public interface InvestorRepository extends JpaRepository<Investor, Long> {
}