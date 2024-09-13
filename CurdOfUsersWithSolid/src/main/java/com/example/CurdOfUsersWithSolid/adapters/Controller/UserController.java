package com.example.CurdOfUsersWithSolid.adapters.Controller;

import com.example.CurdOfUsersWithSolid.core.useCases.useCasesAbstractions.*;
import com.example.CurdOfUsersWithSolid.dtos.CreateUserDto;
import com.example.CurdOfUsersWithSolid.adapters.outputDtoAdapter.OutputDto;
import com.example.CurdOfUsersWithSolid.dtos.UpdateUserDto;
import com.example.CurdOfUsersWithSolid.factory.UseCaseFactory;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.reflect.InvocationTargetException;

@RestController
@RequestMapping("/users")
public class UserController {

    private final RegisterUserUseCase register;
    private final GetOneUserUseCase getOne;
    private final GetAllUsersUseCase getAll;
    private final UpdateUserUseCase update;
    private final DeleteUserUseCase delete;
    private final OutputDto outputDto;

    @Autowired
    public UserController(UseCaseFactory useCaseFactory, OutputDto outputDto) {
        this.register = useCaseFactory.createUserUseCase();
        this.getAll = useCaseFactory.createGetAllUsersUseCase();
        this.getOne = useCaseFactory.createGetOneUserUseCase();
        this.update = useCaseFactory.createUpdateUserUseCase();
        this.delete = useCaseFactory.createDeleteUserUseCase();
        this.outputDto = outputDto;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> createUser(@RequestBody @Valid CreateUserDto req, UriComponentsBuilder uriBuilder) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        var entity = this.register
                .execute(
                        req.name(),
                        req.email(),
                        req.password(),
                        req.cpf(),
                        req.phone());

        var dto = outputDto.createOutputDto(entity.getId(), entity.getName(), entity.getEmail(), entity.getCpf(), entity.getPhone());

        var id = dto.getClass().getMethod("id").invoke(dto);
        var uri = uriBuilder.path("/{id}").buildAndExpand(id).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity<Page<?>> getAllUsers() {
        var response = this.getAll.execute();
        var list = response.stream()
                .map(e -> outputDto.createOutputDto(e.getId(), e.getName(), e.getEmail(), e.getCpf(), e.getPhone()))
                .toList();
        var page = new PageImpl<>(list);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOnUser(@PathVariable Long id) {
        var entity = this.getOne.execute(id);
        var dto = outputDto.createOutputDto(entity.getId(), entity.getName(), entity.getEmail(), entity.getCpf(), entity.getPhone());

        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> updateUser(@RequestBody UpdateUserDto dto, @PathVariable Long id) {

        var entity = this.update.execute(id, dto.email(), dto.password());

        var response = outputDto.createOutputDto(entity.getId(), entity.getName(), entity.getEmail(), entity.getCpf(), entity.getPhone());
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        this.delete.execute(id);
        return ResponseEntity.noContent().build();
    }
}
