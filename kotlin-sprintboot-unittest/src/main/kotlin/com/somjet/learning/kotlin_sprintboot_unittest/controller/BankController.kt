package com.somjet.learning.kotlin_sprintboot_unittest.controller

import com.somjet.learning.kotlin_sprintboot_unittest.entity.BankAccount
import com.somjet.learning.kotlin_sprintboot_unittest.service.BankAccountService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/bankAccount")
class BankController(var bankAccountService: BankAccountService) {
    @PostMapping
    fun addBankAccount(@RequestBody bankAccount: BankAccount): ResponseEntity<BankAccount> {
        return ResponseEntity.ok(bankAccountService.addBankAccount(bankAccount))
    }

    @GetMapping
    fun getBankAccount(@RequestParam id: Long): ResponseEntity<BankAccount> {
        val bankAccount: BankAccount? = bankAccountService.getBankAccount(id)
        return if (bankAccount != null) {
            ResponseEntity(bankAccount, HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }
}