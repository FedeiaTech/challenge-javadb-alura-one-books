package com.fedeiatech.booktrackr.repository;

import com.fedeiatech.booktrackr.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.Year;
import java.util.List;
import java.util.Optional;


public interface AutorRepository extends JpaRepository<Autor, Long> {

    Optional<Autor> findByNombre(String nombre);

    List<Autor> findByAnioNacimiento(Year anio);

    List<Autor> findByAnioFallecimiento(Year anio);

    @Query("SELECT a FROM Autor a WHERE a.anioNacimiento <= :anio AND (a.anioFallecimiento IS NULL OR a.anioFallecimiento >= :anio)")
    List<Autor> buscarAutoresVivosPorAnio(Year anio);
}
