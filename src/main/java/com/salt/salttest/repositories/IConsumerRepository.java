package com.salt.salttest.repositories;

import com.salt.salttest.model.Consumers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IConsumerRepository extends JpaRepository<Consumers, UUID> {
}
