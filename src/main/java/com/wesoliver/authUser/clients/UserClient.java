package com.wesoliver.authUser.clients;

import com.wesoliver.authUser.dtos.CourseDTO;
import com.wesoliver.authUser.dtos.ResponsePageDTO;
import com.wesoliver.authUser.services.UtilsService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Log4j2
@Component
public class UserClient {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UtilsService utilsService;

    public Page<CourseDTO> getAllCoursesByUser(UUID userId, Pageable pageable) {
        List<CourseDTO> searchResult = null;

        String url = utilsService.createUrl(userId, pageable);

        log.debug("Request URL: {} ", url);
        log.info("Request URL: {} ", url);
        try{
            ParameterizedTypeReference<ResponsePageDTO<CourseDTO>> responseType =
                    new ParameterizedTypeReference<ResponsePageDTO<CourseDTO>>() {};

            ResponseEntity<ResponsePageDTO<CourseDTO>> result =
                    restTemplate.exchange(url, HttpMethod.GET, null, responseType);
            searchResult = result.getBody().getContent();



            log.debug("Response Number of Elements: {} ", searchResult.size());
        } catch (HttpStatusCodeException ex) {
            log.error("Ending request /courses userId {} ", userId);
        }
        log.info("Ending request /courses userId {} ", userId);
        return new PageImpl<>(searchResult);
    }

}
