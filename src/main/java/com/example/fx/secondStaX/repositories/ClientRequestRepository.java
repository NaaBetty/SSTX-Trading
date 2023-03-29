package com.example.fx.secondStaX.repositories;
import com.example.fx.secondStaX.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRequestRepository extends JpaRepository<Client, Long> {
}