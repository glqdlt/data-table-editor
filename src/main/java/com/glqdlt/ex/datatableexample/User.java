package com.glqdlt.ex.datatableexample;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class User {

    private Integer id;
    private String name;
    private UserSex sex;
    private Date birthday;

    enum UserSex{
        Man,Woman
    }
}
