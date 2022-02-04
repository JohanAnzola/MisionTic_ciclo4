package com.misiontic.account_ms.controllers;

import com.misiontic.account_ms.exceptions.AccountNotFoundException;
import com.misiontic.account_ms.models.Account;
import com.misiontic.account_ms.repositories.AccountRepository;
import org.springframework.web.bind.annotation.*;
@RestController
public class AccountController {
    private final AccountRepository accountRepository;
    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @GetMapping("/accounts/{username}")
    Account getAccount(@PathVariable String username){
        return accountRepository.findById(username)
                .orElseThrow(() -> new AccountNotFoundException("No se encontro una cuenta " +
                        "con el username: " + username));
    }
    @PostMapping("/accounts")
    Account newAccount(@RequestBody Account account){
        return accountRepository.save(account);
    }
/*
    @PostMapping("/account")
    Account newAccount(@RequestBody Account account) {
        Account accountVerify = accountRepository.findById(account.getUsername()).orElse(null);
        if (accountVerify != null) {
            //la cuenta de origen no existe
            throw new AccountNotFoundException("Ya existe una cuenta con el nombre de " + account.getUsername());
        }
        return accountRepository.save(account);
        //db.account.insert({...})
    }
*/
}

