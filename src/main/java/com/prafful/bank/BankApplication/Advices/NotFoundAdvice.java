package com.prafful.bank.BankApplication.Advices;

import com.prafful.bank.BankApplication.Exceptions.AccountNotFoundException;
import com.prafful.bank.BankApplication.Exceptions.BranchNotFoundException;
import com.prafful.bank.BankApplication.Exceptions.LoanNotFoundException;
import com.prafful.bank.BankApplication.Exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NotFoundAdvice {

    @ResponseBody
    @ExceptionHandler({
            UserNotFoundException.class,
            BranchNotFoundException.class,
            AccountNotFoundException.class,
            LoanNotFoundException.class
    })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFoundAdvice(UserNotFoundException ex) {
        return ex.getMessage();
    }
}
