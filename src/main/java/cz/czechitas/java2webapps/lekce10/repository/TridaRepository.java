package cz.czechitas.java2webapps.lekce10.repository;

import com.sun.xml.bind.v2.model.core.ID;
import cz.czechitas.java2webapps.lekce10.entity.Trida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 */
@Repository
public interface TridaRepository  extends JpaRepository<Trida, Short> {
    Optional<Trida> findById(ID id);
}
