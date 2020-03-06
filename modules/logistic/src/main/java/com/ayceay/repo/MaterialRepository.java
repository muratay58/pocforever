package com.ayceay.repo;

import com.ayceay.entities.MaterialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface MaterialRepository extends JpaRepository<MaterialEntity, Long> {

}
