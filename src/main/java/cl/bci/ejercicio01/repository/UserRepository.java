package cl.bci.ejercicio01.repository;

import cl.bci.ejercicio01.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {}
