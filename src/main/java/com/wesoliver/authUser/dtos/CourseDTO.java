package com.wesoliver.authUser.dtos;

import com.wesoliver.authUser.enums.CourseLevel;
import com.wesoliver.authUser.enums.CourseStatus;
import lombok.Data;

import java.util.UUID;

@Data
public class CourseDTO {

    private UUID courseId;
    private String name;
    private String description;
    private CourseStatus courseStatus;
    private UUID userInstructor;
    private CourseLevel courseLevel;

}
