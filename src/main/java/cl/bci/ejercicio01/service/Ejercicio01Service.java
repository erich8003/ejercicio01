package cl.bci.ejercicio01.service;

import cl.bci.ejercicio01.config.JWebToken;
import cl.bci.ejercicio01.domain.Phones;
import cl.bci.ejercicio01.domain.User;
import cl.bci.ejercicio01.exception.DuplicatedUserException;
import cl.bci.ejercicio01.model.request.Ejercicio01Request;
import cl.bci.ejercicio01.model.request.PhonesRequest;
import cl.bci.ejercicio01.repository.PhonesRepository;
import cl.bci.ejercicio01.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Date;
import java.util.List;

@Service
public class Ejercicio01Service {
    @Autowired
    private ApplicationContext context;




    public User createUser(Ejercicio01Request request) throws DuplicatedUserException {

        PhonesRepository phonesRepo = context.getBean(PhonesRepository.class);

       
        UserRepository userRepo = context.getBean(UserRepository.class);

        List<User> existUser  = userRepo.findByEmail(request.getEmail());
        if(existUser.size()>0){
            throw new DuplicatedUserException("El usuario ya existe");
        }


        User user = new User();
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setCreated(new Date());
        user.setActive(Boolean.TRUE);
        user.setPassword(Base64.getEncoder().encodeToString(request.getPassword().getBytes()));
        user.setToken(JWebToken.createToken(request));
        User savedUser = userRepo.save(user);

        for (PhonesRequest strTemp : request.getPhone()){
            Phones phones = new Phones();
            phones.setPhonenumber(strTemp.getPhonenumber());
            phones.setCitycode(strTemp.getCitycode());
            phones.setUser(savedUser);
            phonesRepo.save(phones);

        }

        return savedUser;
    }


}
