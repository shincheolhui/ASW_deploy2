package com.lec.spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HomeController {

    @Value("${env.info}")
    private String envInfo;

    @GetMapping("/aws/v2")
    public String hello(@RequestParam(defaultValue = "1") Integer num) {
        if (num == 1){
            log.info("[" + envInfo + "] /aws/v2 info로그 #########################");
        } else if (num == -1) {
            log.error("[" + envInfo + "] /aws/v2 error로그 #########################");
        } else if (num == 0) {
            log.warn("[" + envInfo + "] /aws/v2 warn로그 #########################");
//            log.debug("/aws/v1 debug로그 #########################");
        }
        return "<h1>AWS 배포 v2</h1>";
    }
}
