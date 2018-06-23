package com.glqdlt.ex.datatableexample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class SomeRestController {
    @Autowired
    SomeService service;

    @GetMapping("/api/user/find")
    public DataTableVo<User> findUsers(@RequestParam(name = "searchType") Integer searchType, @RequestParam(name = "keyWord") String keyWord) {
        log.info("type : {}, keyword : {}", searchType, keyWord);
//        draw는 클릭 몇번했는지에 대해 체킹하고자 하는 것으로 암.
        if (searchType == 1 && !keyWord.equals("")) {
            List<User> user = service.findUser(keyWord);
            return new DataTableVo<>(user, 1, user.size(), user.size());
        }
        List<User> users = service.findUsers();
        return new DataTableVo<>(users, 1, users.size(), users.size());
    }

    @PostMapping("/api/user/remove")
    public ResultEditorVO<String> removeUser(@RequestParam(value = "id") String userId) {
        log.info("Get ID : {}", userId);
        service.removeUser(Integer.parseInt(userId));
//       remove 의 경우 data 필드에 빈 배열이 올 거라고 기대를 한다고 한다. return {data : []}
        return new ResultEditorVO<>();
    }

    @PostMapping("/api/user/edit")
    public ResultEditorVO<Map<String, String>> editUser(@RequestParam(value = "id") String userId,
                                                        @RequestParam(value = "sex") User.UserSex sex,
                                                        @RequestParam(value = "name") String name,
                                                        @RequestParam(value = "birthday") String day) {

        ResultEditorVO<Map<String, String>> result = new ResultEditorVO<>();
        List<Map<String, String>> list = new ArrayList<>();
        Map<String,String> data = new HashMap<>();
        data.put("id",userId);
        data.put("sex",User.UserSex.Man.name());
        data.put("name",name);
        data.put("birthday",day);
        list.add(data);
        result.setData(list);
//        return {data : {id : userId, sex : UserSexMan.name, name : name, birthday: day}} 으로 리턴주면 jquery editor 는 이에 맞게 location.reload() 안하고도 데이터를 갱신한다.
        return result;
    }
}
