package cl.bci.ejercicio01.controller;

import cl.bci.ejercicio01.domain.User;
import cl.bci.ejercicio01.model.request.Ejercicio01Request;
import cl.bci.ejercicio01.model.response.ResponseCreateUser;
import cl.bci.ejercicio01.service.Ejercicio01Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@Validated
public class Ejercicio01Controller {

    @Autowired
    Ejercicio01Service service;

    @PostMapping(value = "/sign-up",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<ResponseCreateUser>  create(@Valid @RequestBody Ejercicio01Request request) throws Exception {
        ResponseCreateUser responseCreateUser = new ResponseCreateUser();
        User user = service.createUser(request);
        responseCreateUser.setCreated(user.getCreated());
        responseCreateUser.setId(user.getId().toString());
        responseCreateUser.setToken(user.getToken());
        responseCreateUser.setLastLogin(user.getLastLogin());
        return new ResponseEntity<>(responseCreateUser,HttpStatus.CREATED);
    }
}
