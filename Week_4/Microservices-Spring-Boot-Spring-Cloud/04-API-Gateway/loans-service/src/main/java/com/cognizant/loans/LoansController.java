package com.cognizant.loans;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {

    @GetMapping("/loans/{number}")
    public Loan getLoan(@PathVariable String number) {
        return new Loan(number, "car", 400000.00, 3258.00, 18);
    }
}
