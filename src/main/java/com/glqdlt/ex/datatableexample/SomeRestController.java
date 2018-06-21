package com.glqdlt.ex.datatableexample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class SomeRestController {
    @Autowired
    SomeService service;

    @GetMapping("/api/user/find/all")
    public DataTableVo<User> findUsers() {
        List<User> users = service.findUsers();
        return new DataTableVo<>(users, 1, users.size(),users.size());
    }

}
