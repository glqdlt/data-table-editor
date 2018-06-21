package com.glqdlt.ex.datatableexample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class SomeRestController {
    @Autowired
    SomeService service;

    @GetMapping("/api/user/find")
    public DataTableVo<User> findUsers(@RequestParam(name = "searchType") Integer searchType, @RequestParam(name = "keyWord") String keyWord) {
        log.info("type : {}, keyword : {}", searchType, keyWord);
        if(searchType == 1 && !keyWord.equals("")){
            List<User> user = service.findUser(keyWord);
            return new DataTableVo<>(user, 1, user.size(), user.size());
        }
        List<User> users = service.findUsers();
        return new DataTableVo<>(users, 1, users.size(), users.size());
    }

}
