package com.example.sqldatabasenew.controller;

import com.example.sqldatabasenew.service.Service;
import com.example.sqldatabasenew.users.UsersData;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class Controller {
    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("/allusers")
    public List<UsersData> getAllUsers() {
        return service.getAllUsers();
    }

    @PostMapping("/addusers")
    public UsersData postAddUsers(@RequestBody UsersData usersData) {
        return service.postAddUsers(usersData);
    }

    @DeleteMapping("/deleteallusers")
    public String deleteAll(@RequestBody UsersData usersData) {
        return service.deleteAll(usersData);
    }

    @PutMapping("/{editUsersID}")
    public UsersData editUsers(@PathVariable Long editUsersID, @RequestBody UsersData usersData) {
        return service.editUsers(editUsersID, usersData);
    }

    @GetMapping("/{usersID}")
    public Optional<UsersData> getIdUsers(@PathVariable Long usersID) {
        return service.getIdUsers(usersID);
    }

    @DeleteMapping("/{deleteID}")
    public String deleteIdUsers(@PathVariable Long deleteID) {
        return service.deleteIdUsers(deleteID);
    }

    @GetMapping("/findSurname")
    public List<UsersData> findSurname(@RequestParam String findSurname) {
        return service.findSurname(findSurname);
    }

    @GetMapping("/findName")
    public List<UsersData> findName(@RequestParam String findName) {
        return service.findName(findName);
    }

    @GetMapping("/findAge")
    public List<UsersData> findAge(@RequestParam Integer findAge) {
        return service.findAge(findAge);
    }

    @GetMapping("/filterAll")
    public List<UsersData> findAll(@RequestParam("name") String filterName, @RequestParam("surname") String filterSurname, @RequestParam("age") Integer filterAge) {
        return service.findAll(filterName, filterSurname,filterAge);
    }

}
