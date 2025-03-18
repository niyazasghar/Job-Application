package com.niyaz.gateway.controller;

import com.niyaz.gateway.config.CustomUserDetails;
import com.niyaz.gateway.dto.UserInfoDTO;
import com.niyaz.gateway.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/api/userinfo")
    public Mono<UserInfoDTO> getUserInfo(@AuthenticationPrincipal CustomUserDetails customUserDetails) {
        System.out.println("hello");
        return userInfoService.getUserInfo(customUserDetails);
    }
}
