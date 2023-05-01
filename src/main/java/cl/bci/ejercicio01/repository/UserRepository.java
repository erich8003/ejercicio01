package cl.bci.ejercicio01.repository;

import cl.bci.ejercicio01.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, String> {

    List<User> findByEmail(String email);


}
