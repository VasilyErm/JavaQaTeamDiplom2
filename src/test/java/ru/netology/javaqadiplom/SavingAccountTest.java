package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {
    SavingAccount account = new SavingAccount(
            2_000,
            1_000,
            10_000,
            5
    );

    @Test
    public void test1() { // ПОПОЛНЕНИЕ СЧЕТА. при пополнении счета выводит не верный баланс

        account.add(3_000); // пополнение на 3 000, в кошельке было 2 000 итог должен быть 5 000.

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test
    public void test2() { //ПЕРЕВОД С КАРТЫ НА КАРТУ.+

        account.pay(500);

        Assertions.assertEquals(2_000 - 500, account.getBalance());
    }

    @Test
    public void test3() { //ПЕРЕВОД С КАРТЫ НА КАРТУ.+

        account.pay(1_500);

        Assertions.assertEquals(2_000 - 1_500, account.getBalance());
    }

    @Test
    public void test4() { //ПЕРЕВОД С КАРТЫ НА КАРТУ.

        account.pay(2_500); // выдает отрицательный баланс на счету -500. операция должна
        //* завершиться вернув false и ничего не поменяв на счёте.

        Assertions.assertEquals(2_000 - 2_500, account.getBalance());
    }

    @Test
    public void test5() { //РАСЧЕТ ПРОЦЕНТОВ НА ОСТАТОК 2 000.

        account.yearChange();// не накидывает проценты на остаток по счету, должно быть 2 100, остается 2 000!

        Assertions.assertEquals(2_000 + 100, account.getBalance() + account.yearChange());
    }

    @Test
    public void test6() { // МАКСИМАЛЬНЫЙ БАЛАНС

        account.getMaxBalance();

        Assertions.assertEquals(10_000, account.maxBalance);
    }

    @Test
    public void test7() { // МИНИМАЛЬНЫЙ БАЛАНС

        account.getMinBalance();

        Assertions.assertEquals(1_000, account.minBalance);
    }

    @Test
    public void test8() { // Пополнение на отрицательное значение


        account.pay(-10);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void test9() { // Процентная ставка отрицательная
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    2_000,
                    1_000,
                    10_000,
                    -5
            );
        });
    }

    @Test
    public void test10() { // Максимальный баланс отрицательный
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    2_000,
                    1_000,
                    -10_000,
                    5
            );
        });
    }

    @Test
    public void test11() { // Минимальный баланс отрицательный
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    2_000,
                    -1_000,
                    10_000,
                    5
            );
        });
    }

    @Test
    public void test12() { // Текущий баланс отрицательный
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    -2_000,
                    1_000,
                    10_000,
                    5
            );
        });
    }

    @Test
    public void test13() { //Отрицательная сумма покупки

        account.pay(-500);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void test14() { // ПОПОЛНЕНИЕ СЧЕТА на сумму больше максимального баланса

        account.add(13_000);
        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void test15() { // ПОПОЛНЕНИЕ СЧЕТА на отрицательную сумму

        account.add(-3_000);
        Assertions.assertEquals(2_000, account.getBalance());
    }
}
