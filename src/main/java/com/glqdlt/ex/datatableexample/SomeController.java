package com.glqdlt.ex.datatableexample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/")
public class SomeController {
    @GetMapping("web/user")
    public String userTable(){
        return "user-table";
    }

}
