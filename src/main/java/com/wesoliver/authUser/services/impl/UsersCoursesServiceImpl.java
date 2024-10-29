package com.wesoliver.authUser.services.impl;

import com.wesoliver.authUser.repositorys.UsersCoursesRepository;
import com.wesoliver.authUser.services.UsersCoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersCoursesServiceImpl implements UsersCoursesService {

    @Autowired
    private UsersCoursesRepository usersCoursesRepository;
}
