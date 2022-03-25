import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import ru.netology.*

internal class MaximumCoverageKtTest {

    @Test
    fun negativeMoney() {
        val prevSum = 100000L
        val curSum = -1000L
        val result = calculateCommission(prevSum, curSum)

        assertEquals(STATUS_CODE_NEGATIVE_MONEY, result)
    }

    @Test
    fun moneyPerDayExceeded() {
        val prevSum = 100000L
        val curSum = 15_500_000L
        val result = calculateCommission(prevSum, curSum)

        assertEquals(STATUS_CODE_MAX_MONEY_PER_DAY_EXCEEDED, result)
    }

    @Test
    fun maxMoneyPerMonthExceeded() {
        val prevSum = 60000000L
        val curSum = 10000000L
        val cardType = "Мир"
        val result = calculateCommission(prevSum, curSum, cardType)

        assertEquals(STATUS_CODE_MAX_MONEY_PER_MOUNTH_EXCEEDED, result)
    }

    @Test
    fun vkPay() {
        val prevSum = 3000000L
        val curSum = 1000000L
        val cardType = "VKPay"
        val result = calculateCommission(prevSum, curSum, cardType)

        assertEquals(0L, result)
    }

    @Test
    fun masterCard() {
        val prevSum = 5000000L
        val curSum = 2000000L
        val cardType = "MasterCard"
        val action = true
        val result = calculateCommission(prevSum, curSum, cardType, action)

        assertEquals(0L, result)
    }

    @Test
    fun maestro() {
        val prevSum = 6000000L
        val curSum = 1000000L
        val cardType = "Maestro"
        val action = true
        val result = calculateCommission(prevSum, curSum, cardType, action)

        assertEquals(0L, result)
    }

    @Test
    fun masterCardNoAction() {
        val prevSum = 5000000L
        val curSum = 2000000L
        val cardType = "MasterCard"
        val action = false
        val result = calculateCommission(prevSum, curSum, cardType, action)

        assertEquals(14000, result)
    }

    @Test
    fun maestroNoAction() {
        val prevSum = 5000000L
        val curSum = 2000000L
        val cardType = "Maestro"
        val action = false
        val result = calculateCommission(prevSum, curSum, cardType, action)

        assertEquals(14000, result)
    }

    @Test
    fun visaMinCommission() {
        val prevSum = 5000000L
        val curSum = 100000L
        val cardType = "Visa"
        val result = calculateCommission(prevSum, curSum, cardType)

        assertEquals(3500, result)
    }

    @Test
    fun mirMinCommission() {
        val prevSum = 30000000L
        val curSum = 100000L
        val cardType = "Мир"
        val result = calculateCommission(prevSum, curSum, cardType)

        assertEquals(3500, result)
    }

    @Test
    fun visa() {
        val prevSum = 5000000L
        val curSum = 1000000L
        val cardType = "Visa"
        val result = calculateCommission(prevSum, curSum, cardType)

        assertEquals(7500, result)
    }

    @Test
    fun mir() {
        val prevSum = 30000000L
        val curSum = 1000000L
        val cardType = "Мир"
        val result = calculateCommission(prevSum, curSum, cardType)

        assertEquals(10000, result)
    }

    @Test
    fun cardNotSupported() {
        val prevSum = 100000L
        val curSum = 1550000L
        val cardType = "Альфа Банк"
        val result = calculateCommission(prevSum, curSum, cardType)

        assertEquals(STATUS_CODE_CARD_NOT_SUPPROTED, result)
    }
}