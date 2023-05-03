package service;


import cl.bci.ejercicio01.domain.User;
import cl.bci.ejercicio01.model.request.Ejercicio01Request;
import cl.bci.ejercicio01.model.request.PhonesRequest;
import cl.bci.ejercicio01.repository.PhonesRepository;
import cl.bci.ejercicio01.repository.UserRepository;
import cl.bci.ejercicio01.service.Ejercicio01Service;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.ApplicationContext;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class Ejercicio01ServiceTest {

    @Mock
    ApplicationContext context;
    @InjectMocks
    Ejercicio01Service ejercicio01Service = new Ejercicio01Service();;

    Ejercicio01Request ejercicio01Request;
    @Mock
    PhonesRepository phonesRepository;

    @Mock
    UserRepository userRepository;



@Test
public void createUser() throws Exception {
    String name="juan perez";
    String email="juanito@hotmail.com";
    String password="a2asfGfdfdf4";
    User dummyUser = new User();
    dummyUser.setName(name);
    dummyUser.setPassword(password);
    dummyUser.setEmail(email);
    PhonesRequest[] phones=new PhonesRequest[1];
    phones[0] = new PhonesRequest(345634562,34523,"AR");
    ejercicio01Request = new Ejercicio01Request(name,email,password,phones);
    when(context.getBean(PhonesRepository.class)).thenReturn(phonesRepository);
    when(context.getBean(UserRepository.class)).thenReturn(userRepository);
    when(userRepository.save(any())).thenReturn(dummyUser);
    Assert.assertNotNull(ejercicio01Service.createUser(ejercicio01Request));
}

}
