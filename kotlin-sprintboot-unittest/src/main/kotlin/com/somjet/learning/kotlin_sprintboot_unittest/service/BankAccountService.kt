package com.somjet.learning.kotlin_sprintboot_unittest.service

import com.somjet.learning.kotlin_sprintboot_unittest.entity.BankAccount
import com.somjet.learning.kotlin_sprintboot_unittest.repository.BankAccountRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class BankAccountService(var bankAccountRepository: BankAccountRepository) {
    fun addBankAccount(bankAccount: BankAccount): BankAccount {
        return bankAccountRepository.save(bankAccount)
    }

    fun getBankAccount(id: Long): BankAccount? {
        return bankAccountRepository.findByIdOrNull(id)
    }
}