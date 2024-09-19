package com.example.sqldatabasenew.service;

import com.example.sqldatabasenew.errormessage.ErrorMessage;
import com.example.sqldatabasenew.repositary.Repositary;
import com.example.sqldatabasenew.users.UsersData;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {
    private final Repositary repositary;

    public Service(Repositary repositary) {
        this.repositary = repositary;
    }

    public List<UsersData> getAllUsers() {
        return repositary.findAll();
    }

    public UsersData postAddUsers(UsersData usersData) {
        if (usersData.getName() != null  && usersData.getSurname() != null) {
            return repositary.save(usersData);
        } else {
            throw new ErrorMessage("Bu Melumat Bos Ola Bilmez");
        }
    }

    public String deleteAll(UsersData usersData) {
        if (usersData.getName() == null  && usersData.getSurname() == null) {
            return "Hesab yoxdur";
        } else {
            repositary.deleteAll();
            return "Butun Hesablar Silindi";
        }
    }
    public UsersData editUsers(Long editUsersID, UsersData usersData) {
        UsersData usersDataDB = repositary.findById(editUsersID).get();
        usersDataDB.setName(usersData.getName());
        usersDataDB.setSurname(usersData.getSurname());
        repositary.save(usersDataDB);
        return usersDataDB;
    }

    public Optional<UsersData> getIdUsers(Long usersID) {

        return repositary.findById(usersID);
    }

    public String deleteIdUsers(Long deleteID) {
        repositary.deleteById(deleteID);
        return "Bu Nomreli Hesab Silindi";
    }

    public List<UsersData> findSurname(String findSurname) {
        return repositary.findBySurname(findSurname);
    }
    public List<UsersData> findName(String findName){
        return repositary.findByName(findName);
    }
    public List<UsersData> findAge(Integer findAge) {
        return repositary.findByAge(findAge);
    }
    public List<UsersData> findAll(String filterName, String filterSurname,Integer filterAge) {
        return repositary.findAll(filterName,filterSurname,filterAge);
    }


}
