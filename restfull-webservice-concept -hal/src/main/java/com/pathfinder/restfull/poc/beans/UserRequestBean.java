package com.pathfinder.restfull.poc.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestBean{
    private String name;
    private String email;
    private String city;
    private String status;
    private List<String> phones;
    private String dob;


    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public List<String> getPhones(){
        return phones;
    }

    public void setPhones(List<String> phones){
        this.phones = phones;
    }

    public String getDob(){
        return dob;
    }

    public void setDob(String dob){
        this.dob = dob;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(ToStringStyle.JSON_STYLE);
    }
}
