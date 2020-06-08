package com.prafful.bank.BankApplication.Advices;

import com.prafful.bank.BankApplication.Exceptions.BranchNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BranchNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(BranchNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String branchNotFoundAdvice(BranchNotFoundException ex) {
        return ex.getMessage();
    }
}
