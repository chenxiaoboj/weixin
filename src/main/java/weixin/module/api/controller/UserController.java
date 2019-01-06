package weixin.module.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenx 2018-10-29 10:34
 */

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping
    public String getUsers() {
        return "Hello Spring Security";
    }
}
