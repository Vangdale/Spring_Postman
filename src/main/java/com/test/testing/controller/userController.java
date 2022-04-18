package com.test.testing.controller;

import com.test.testing.model.*;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:8080")
public class userController {

    private test1 usuario =new test1();
    private NewDataCopy test4 = new NewDataCopy();
    private GetTestUser test5 = new GetTestUser();
    List<user> users = new ArrayList<>();
    private pet mascota = new pet();

    //test numero 1
    @GetMapping("/login")
    public ResponseEntity<test1> login(String login, String password){

        usuario.setLogin(login);
        usuario.setPassword(password);
        usuario.setInfo("Login success");
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    //test numero 2
    @PostMapping("/user_info")
    public ResponseEntity<List<user>> getUserInfo(){
        return ResponseEntity.ok(users);
    }

    //test numero 4
    @PostMapping("/new_data")
    public ResponseEntity<NewDataCopy> newDataCopy(){

        var first_salary= 10;
        var secon_salary = first_salary * 2;
        var third_salary = first_salary * 3;
        test4.setSalary(new int[]{first_salary, secon_salary, third_salary});
        return new ResponseEntity<>(test4, HttpStatus.OK);
    }

    //test pets
    @PostMapping("/test_pet_info")
    public ResponseEntity<pet> getPetInfo(){
        mascota.setDaily_food(0.96);
        mascota.setDaily_sleep(200);
        return new ResponseEntity<>(mascota, HttpStatus.OK);
    }

    //test5
    @GetMapping("get_test_user/{id}")
    public ResponseEntity<GetTestUser> GetTestUser(String id, String name, @RequestParam("id") String newID){
        test5.setId(newID);
        test5.setName(name);

        return new ResponseEntity<>(test5, HttpStatus.OK);

    }

}
