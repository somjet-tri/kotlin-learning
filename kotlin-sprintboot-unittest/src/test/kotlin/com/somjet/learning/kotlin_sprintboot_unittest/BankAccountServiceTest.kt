package com.somjet.learning.kotlin_sprintboot_unittest

import com.somjet.learning.kotlin_sprintboot_unittest.entity.BankAccount
import com.somjet.learning.kotlin_sprintboot_unittest.repository.BankAccountRepository
import com.somjet.learning.kotlin_sprintboot_unittest.service.BankAccountService
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.data.repository.findByIdOrNull

class BankAccountServiceTest {
    private val bankAccountRepository: BankAccountRepository = mockk()
    private val bankAccountService: BankAccountService = BankAccountService(bankAccountRepository)
    private val bankAccount: BankAccount = BankAccount("ING", "123ING456", "JOHN SMITH")

    @Test
    fun whenGetBankAccount_thenReturnBankAccount() {
        //given
        every { bankAccountRepository.findByIdOrNull(1) } returns bankAccount

        //when
        val result = bankAccountService.getBankAccount(1)

        //then
        verify(exactly = 1) { bankAccountRepository.findByIdOrNull(1) }
        assertEquals(bankAccount, result)
    }
}