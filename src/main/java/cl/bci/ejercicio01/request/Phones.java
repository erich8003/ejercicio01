package cl.bci.ejercicio01.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Phones {
    @JsonProperty("number")
    private long phonenumber;
    @JsonProperty("citycode")
    private int citycode;
    @JsonProperty("countrycode")
    private String countrycode;


    public Phones(long phoneNumber, int cityCode, String countryCode) {
        this.phonenumber = phoneNumber;
        this.citycode = cityCode;
        this.countrycode = countryCode;
    }

    public long getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(long phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getCitycode() {
        return citycode;
    }

    public void setCitycode(int citycode) {
        this.citycode = citycode;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }


}
