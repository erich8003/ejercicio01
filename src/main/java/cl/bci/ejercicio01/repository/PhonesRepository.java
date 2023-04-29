package cl.bci.ejercicio01.repository;

import cl.bci.ejercicio01.domain.Phones;
import org.springframework.data.repository.CrudRepository;

public interface PhonesRepository extends CrudRepository<Phones, Long> {

}