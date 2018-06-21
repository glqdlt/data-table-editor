package com.glqdlt.ex.datatableexample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@Service
public class SomeService {
    private final List<User> data;

    public SomeService() {
        this.data = IntStream.range(1, 100).boxed().map(i -> {
            User.UserSex someSex = User.UserSex.Woman;
            if (i % 2 == 0) {
                someSex = User.UserSex.Man;
            }
            return new User(i, "some-user-" + i, someSex);
        }).collect(Collectors.toList());
    }

    public List<User> findUsers() {
        List<User> users = data;
        return users;
    }

    public List<User> findUser(String keyWord) {
        return data.stream().filter(x -> x.getName().equals(keyWord)).collect(Collectors.toList());
    }
}
