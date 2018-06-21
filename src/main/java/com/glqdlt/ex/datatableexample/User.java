package com.glqdlt.ex.datatableexample;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class User {

    private Integer id;
    private String name;
    private UserSex sex;

    enum UserSex{
        Man,Woman
    }
}
