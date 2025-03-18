package com.niyaz.gateway.service;

import com.niyaz.gateway.config.CustomUserDetails;
import com.niyaz.gateway.dto.UserInfoDTO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserInfoService {

    public Mono<UserInfoDTO> getUserInfo(CustomUserDetails customUserDetails) {
        if (customUserDetails == null) {
            return Mono.empty();
        }
        UserInfoDTO dto = new UserInfoDTO();
        dto.setId(customUserDetails.getId());
        dto.setUsername(customUserDetails.getUsername());
        dto.setFirstName(customUserDetails.getFirstName());
        dto.setLastName(customUserDetails.getLastName());
        return Mono.just(dto);
    }
}
