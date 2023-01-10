package com.test.backend.repository;

import com.test.backend.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    Optional<Country> findByName(String name);

    @Query(value = "SELECT * FROM tb_country WHERE region_id = ?1", nativeQuery = true)
    List<Country> findByRegionIdNative(Long id);
}
