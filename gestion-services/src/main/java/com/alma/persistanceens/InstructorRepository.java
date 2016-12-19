package com.alma.persistanceens;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;


@Repository
public interface InstructorRepository extends CrudRepository <Instructor, Long> {
    Set<Instructor> findByName(String name);

    @Query(value = "SELECT * FROM Instructor p WHERE p.name like :pattern", nativeQuery = true)
    Set<Instructor> searchNatively(@Param("pattern") String pattern);

    @Query(value = "FROM Instructor p WHERE p.name like :pattern")
    Set<Instructor> search(@Param("pattern") String pattern);

}
