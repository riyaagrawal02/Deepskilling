package com.cognizant.ormlearn.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    // Query Method Examples (Spring Data JPA derives SQL from method name)
    List<Country> findByNameContaining(String text);

    List<Country> findByNameContainingOrderByNameAsc(String text);

    List<Country> findByNameStartingWith(String alphabet);

    Optional<Country> findByCode(String code);

    @Query("SELECT c FROM Country c WHERE c.name LIKE %:name%")
    List<Country> findCountriesByNameJPQL(@Param("name") String name);

    @Query("SELECT c FROM Country c WHERE c.name LIKE %:pattern% ORDER BY c.name ASC")
    List<Country> findCountriesSortedByName(@Param("pattern") String pattern);

    @Query(value = "SELECT * FROM country WHERE co_name LIKE CONCAT('%', :name, '%')", nativeQuery = true)
    List<Country> findCountriesByNameNativeSQL(@Param("name") String name);

  
    @Query(value = "SELECT * FROM country ORDER BY co_name ASC", nativeQuery = true)
    List<Country> findAllCountriesSorted();
}