package cl.bci.ejercicio01.service;

import cl.bci.ejercicio01.domain.User;
import cl.bci.ejercicio01.repository.UserRepository;
import cl.bci.ejercicio01.request.Ejercicio01Request;
import cl.bci.ejercicio01.response.ResponseCreateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Date;
import java.util.UUID;

@Service
public class Ejercicio01Service {
    @Autowired
    private ApplicationContext context;

    public User createUser(Ejercicio01Request request){

        UserRepository repo = context.getBean(UserRepository.class);
        User user = new User();
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setCreated(new Date());
        user.setActive(Boolean.TRUE);
        user.setPassword(Base64.getEncoder().encodeToString(request.getPassword().getBytes()));
        User user1 = repo.save(user);
        return user1;
    }
}
