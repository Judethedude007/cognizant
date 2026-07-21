package com.cognizant.accounts;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {

    @GetMapping("/accounts/{number}")
    public Account getAccount(@PathVariable String number) {
        return new Account(number, "savings", 234343.00);
    }
}
