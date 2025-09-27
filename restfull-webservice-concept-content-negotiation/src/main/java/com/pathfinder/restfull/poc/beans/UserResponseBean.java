package com.pathfinder.restfull.poc.beans;

import com.pathfinder.restfull.poc.model.UserEntity;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class UserResponseBean{

    private Long id;
    private String name;
    private String email;
    private String city;
    private String status;
    private List<String> phones;
    private String dob;

    public UserResponseBean(){
    }



    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

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

    public UserResponseBean(UserEntity userEntity){
        this.id = userEntity.getId();
        this.name = userEntity.getName();
        this.email = userEntity.getEmail();
        this.city = userEntity.getCity();
        this.status = userEntity.getStatus();
        this.phones = userEntity.getPhones();
        this.dob = userEntity.getDob();
    }
    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(ToStringStyle.JSON_STYLE);
    }
}
