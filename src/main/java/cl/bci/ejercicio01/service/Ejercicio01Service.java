package cl.bci.ejercicio01.service;

import cl.bci.ejercicio01.config.JWebToken;
import cl.bci.ejercicio01.domain.Phones;
import cl.bci.ejercicio01.domain.User;
import cl.bci.ejercicio01.model.request.PhonesRequest;
import cl.bci.ejercicio01.repository.PhonesRepository;
import cl.bci.ejercicio01.repository.UserRepository;
import cl.bci.ejercicio01.model.request.Ejercicio01Request;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Base64;
import java.util.Date;

@Service
public class Ejercicio01Service {
    @Autowired
    private ApplicationContext context;

    private static final int EXPIRY_DAYS = 90;

    public User createUser(Ejercicio01Request request){

        PhonesRepository phonesRepo = context.getBean(PhonesRepository.class);
       
        UserRepository userRepo = context.getBean(UserRepository.class);
        User user = new User();
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setCreated(new Date());
        user.setActive(Boolean.TRUE);
        user.setPassword(Base64.getEncoder().encodeToString(request.getPassword().getBytes()));
        User savedUser = userRepo.save(user);

        for (PhonesRequest strTemp : request.getPhone()){
            Phones phones = new Phones();
            phones.setPhonenumber(strTemp.getPhonenumber());
            phones.setCitycode(strTemp.getCitycode());
            phones.setUser(savedUser);
            phonesRepo.save(phones);

        }

        /* Phones phones = new Phones();
        phones.setCitycode();
        phones.setCountrycode();
        phones.setPhonenumber();*/
        return savedUser;
    }

    public String createToken(){

        JSONObject jwtPayload = new JSONObject();
        jwtPayload.put("status", 0);

        JSONArray audArray = new JSONArray();
        audArray.put("admin");
        jwtPayload.put("sub", "John");

        jwtPayload.put("aud", audArray);
        LocalDateTime ldt = LocalDateTime.now().plusDays(EXPIRY_DAYS);
        jwtPayload.put("exp", ldt.toEpochSecond(ZoneOffset.UTC)); //this needs to be configured

        String token = new JWebToken(jwtPayload).toString();

        return token;

    }
}
