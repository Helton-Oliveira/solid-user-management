package com.example.CurdOfUsersWithSolid.Controller;

import com.example.CurdOfUsersWithSolid.dtos.CreateUserDto;
import com.example.CurdOfUsersWithSolid.dtos.ResponseDto;
import com.example.CurdOfUsersWithSolid.useCases.CreateUserUseCaseImpl;
import com.example.CurdOfUsersWithSolid.useCases.GetAllUsersUseCaseImpl;
import com.example.CurdOfUsersWithSolid.useCases.UseCasesCreate;
import com.example.CurdOfUsersWithSolid.useCases.UseCasesResponse;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.reflect.InvocationTargetException;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UseCasesCreate createCases;
    private final UseCasesResponse casesResponse;

    @Autowired
    public UserController(CreateUserUseCaseImpl useCases, GetAllUsersUseCaseImpl useCasesResponse) {
        this.createCases = useCases;
        this.casesResponse = useCasesResponse;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ResponseDto> createUser(@RequestBody @Valid CreateUserDto req, UriComponentsBuilder uriBuilder) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ResponseDto response = createCases.execute(req);
        var id = response.getClass().getMethod("id").invoke(response);
        var uri = uriBuilder.path("/{id}").buildAndExpand(id).toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<ResponseDto>> getAllUsers() {
        return ResponseEntity.ok(casesResponse.execute());
    }

}
