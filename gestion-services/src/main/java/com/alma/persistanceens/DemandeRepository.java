package com.alma.persistanceens;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.alma.enseignants.Demande;
import com.alma.enseignants.Enseignant;

import java.util.Set;


@Repository
public interface DemandeRepository extends CrudRepository <Demande, Long> {
    Set<Demande> findByEnseignant(Enseignant enseignant);
    
    Set<Demande> findByPublished(boolean publie);

    @Query(value = "SELECT * FROM Demande d WHERE d.name like :pattern", nativeQuery = true)
    Set<Demande> searchNatively(@Param("pattern") String pattern);

    @Query(value = "FROM Demande d WHERE d.name like :pattern")
    Set<Demande> search(@Param("pattern") String pattern);

}
