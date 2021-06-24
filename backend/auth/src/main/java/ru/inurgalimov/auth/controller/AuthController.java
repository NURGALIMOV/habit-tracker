package ru.inurgalimov.auth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;
import ru.inurgalimov.auth.api.AuthApi;
import ru.inurgalimov.auth.dto.User;
import ru.inurgalimov.auth.service.AuthService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AuthController implements AuthApi {

    private final AuthService service;

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getAll() {
        final var all = service.getAll();
        all.forEach(user -> user.setPassword(null));
        return all;
    }

    @Override
    public ResponseEntity<UUID> register(User user) {
        return service.register(user);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public User update(User user) {
        User result = service.update(user);
        result.setPassword(null);
        return result;
    }

    @Override
    @PreAuthorize("hasRole('USER')")
    public String changePassword(UUID userId, String password) {
        return service.changePassword(userId, password);
    }

    @Override
    public ResponseEntity validateToken(String token) {
        HttpHeaders headers = new HttpHeaders();
        final var map = service.validateToken(token);
        headers.add("X-Profile", String.format("%s_%s", map.get("id"), map.get("role")));
        return new ResponseEntity(headers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> login(User user) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, service.login(user.getLogin(), user.getPassword()));
        user.setPassword(null);
        return ResponseEntity.ok(user);
    }

}
