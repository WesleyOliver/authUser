package com.wesoliver.authUser.services;

import com.wesoliver.authUser.models.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {

    List<UserModel> findAll();
    Optional<UserModel> findById(UUID userId);
    void delete(UserModel userModel);
    void save(UserModel userModel);
    boolean existsByUsername(String userName);
    boolean existsByEmail(String email);
    Page<UserModel> findAll(Specification<UserModel> spec, Pageable pageable);
}
