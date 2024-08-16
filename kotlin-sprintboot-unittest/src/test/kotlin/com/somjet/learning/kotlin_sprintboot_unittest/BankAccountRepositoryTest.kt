package com.somjet.learning.kotlin_sprintboot_unittest

import com.somjet.learning.kotlin_sprintboot_unittest.entity.BankAccount
import com.somjet.learning.kotlin_sprintboot_unittest.repository.BankAccountRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.repository.findByIdOrNull

@DataJpaTest
class BankAccountRepositoryTest {
    @Autowired
    lateinit var entityManager: TestEntityManager

    @Autowired
    lateinit var bankAccountRepository: BankAccountRepository

    @Test
    fun whenFindById_thenReturnBankAccount() {
        val ingBankAccount = BankAccount("ING", "123ING456", "JOHN SMITH")
        entityManager.persist(ingBankAccount)
        entityManager.flush()
        ingBankAccount.id = 1
        val ingBankAccountFound = bankAccountRepository.findByIdOrNull(ingBankAccount.id!!)
        assertEquals(ingBankAccount, ingBankAccountFound)
    }
}