package cl.bci.ejercicio01.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Ejercicio01Request {
    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    @Email
    @NotNull
    private String email;

    @Pattern(message="password Debe tener solo una mayuscula y solamente dos numeros",regexp="^(?=.*[A-Z])(?=.*\\d.*\\d)(?=.*[a-z])[A-Za-z\\d]{8,12}$")
    @JsonProperty("password")
    @NotNull
    private String password;

    @JsonProperty("phones")
    private Phones[] phones;

    public Ejercicio01Request(String name, String email, String password, Phones[] phones) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phones = phones;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Phones[] getPhone() {
        return phones;
    }

    public void setPhone(Phones[] phones) {
        this.phones = phones;
    }
}
