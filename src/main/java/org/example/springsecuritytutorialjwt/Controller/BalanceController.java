package org.example.springsecuritytutorialjwt.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {
    @GetMapping("/myBalance")
    public String myBalance() {
        return "Here is your balance";
    }
}
