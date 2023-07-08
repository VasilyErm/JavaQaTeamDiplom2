package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test  // Пополнение счета, при начальном балансе равном 0
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }


    @Test  // Пополнение счета, при начальном балансе равном 1_000
    public void addToBalance1() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(4_000, account.getBalance());
    }

    @Test  // Пополнение счета, при начальном балансе равном -1_000
    public void addToBalance2() {
        CreditAccount account = new CreditAccount(
                -1_000,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test  // Пополнение счета на 0
    public void addToBalance3() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.add(0);

        Assertions.assertEquals(1_000, account.getBalance());
    }


    @Test  // Пополнение счета на отрицательное значение
    public void addToBalance4() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.add(-1_000);

        Assertions.assertEquals(1_000, account.getBalance());
    }


    @Test  // Проверка исключения при корректных параметрах
    public void exceptionTest1() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    1_000,
                    5_000,
                    15
            );
        });
    }

    @Test  // Проверка исключения при некорректных параметрах initialBalance
    public void exceptionTest2() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    -1_000,
                    5_000,
                    15
            );
        });
    }

    @Test  // Проверка исключения при некорректных параметрах creditLimit
    public void exceptionTest3() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    1_000,
                    -5_000,
                    15
            );
        });
    }

    @Test  // Проверка исключения при некорректных параметрах rate
    public void exceptionTest4() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    1_000,
                    5_000,
                    -15
            );
        });
    }

    @Test  // Проверка оплаты, при начальном балансе равном 0, в пределах кредитного лимита
    public void payTest1() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(3_000);

        Assertions.assertEquals(-3_000, account.getBalance());
    }


    @Test  // Проверка оплаты, при начальном балансе равном 1_000, в пределах кредитного лимита
    public void payTest2() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.pay(3_000);

        Assertions.assertEquals(-2_000, account.getBalance()); // ожидаемый результат должен быть 0
    }


    @Test  // Проверка оплаты, при начальном балансе равном 0, с превышением кредитного лимита
    public void payTest3() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(10_000);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test  // Проверка оплаты, при начальном балансе -1_000, в пределах кредитного лимита
    public void payTest4() {
        CreditAccount account = new CreditAccount(
                -1_000,
                5_000,
                15
        );

        account.pay(1_000);

        Assertions.assertEquals(-2_000, account.getBalance()); // ожидаемый 0
    }

    @Test  // Проверка оплаты, при начальном балансе равном -1_000, с превышением кредитного лимита
    public void payTest5() {
        CreditAccount account = new CreditAccount(
                -1_000,
                5_000,
                15
        );

        account.pay(10_000);

        Assertions.assertEquals(-1_000, account.getBalance());
    }

    @Test  // Проверка оплаты, при начальном балансе равном 1_000 на отрицательную сумму
    public void payTest6() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.pay(-1_000);

        Assertions.assertEquals(1_000, account.getBalance());
    }


    @Test  // Операция расчёта процентов, при отсутствии задолженности ,с начальным балансом = 200
    public void rateTest1() {
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );
        Assertions.assertEquals(0, account.yearChange());
    }

    @Test  // Операция расчёта процентов, при отсутствии задолжености,с начальном балансе = 0
    public void rateTest2() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        Assertions.assertEquals(0, account.yearChange());
    }

    @Test  // Операция расчёта процентов, при задолжености
    public void rateTest3() {
        CreditAccount account = new CreditAccount(
                -200,
                5_000,
                15
        );
        Assertions.assertEquals(-30, account.yearChange());
    }

}
