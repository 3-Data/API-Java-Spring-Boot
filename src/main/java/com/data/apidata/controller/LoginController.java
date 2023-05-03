package com.data.apidata.controller;

import com.data.apidata.DTOs.LoginRequestDTO;
import com.data.apidata.DTOs.LoginResponseDTO;
import com.data.apidata.model.Login;
import com.data.apidata.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("login")
public class LoginController {
    @Autowired
    private LoginRepository repository;
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<LoginResponseDTO> getAll() {
        List<LoginResponseDTO> loginList = repository.findAll().stream().map(LoginResponseDTO::new).toList();
        return loginList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void createLogin(@RequestBody LoginRequestDTO data) {
        Login loginData = new Login(data);
        repository.save(loginData);
    }
}
