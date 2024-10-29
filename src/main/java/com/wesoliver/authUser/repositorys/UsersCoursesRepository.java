package com.wesoliver.authUser.repositorys;

import com.wesoliver.authUser.models.UserCourseModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsersCoursesRepository extends JpaRepository<UserCourseModel, UUID> {
}
