package com.ms_kart.repository;

import com.ms_kart.entities.kartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface kartRepository extends JpaRepository<kartEntity,Long> {
    kartEntity findKartEntityByCode(String code);

    List<kartEntity> findKartEntityByModel(String model);
    @Query(value = "SELECT * FROM kart WHERE kart.status = :status", nativeQuery = true)
    List<kartEntity> findKartEntityByStatus(@Param("status") String status);
}
