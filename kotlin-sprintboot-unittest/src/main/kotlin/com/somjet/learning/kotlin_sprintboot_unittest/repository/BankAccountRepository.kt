package com.somjet.learning.kotlin_sprintboot_unittest.repository

import com.somjet.learning.kotlin_sprintboot_unittest.entity.BankAccount
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BankAccountRepository : CrudRepository<BankAccount, Long> {
}