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

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Models.Withdrawal;

@Repository
public interface WithdrawalRepository extends JpaRepository<Withdrawal, Long> {

    List<Withdrawal> findByInvestor_Id(Long investorId);
}
