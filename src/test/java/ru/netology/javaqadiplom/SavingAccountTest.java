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
    }
