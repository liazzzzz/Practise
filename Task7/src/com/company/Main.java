package com.company;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        DbConnection db = new DbConnection();
        Connection connection = db.getConnection("postgres", "postgres", "ien5untu");

        Account account1 = new Account(1L);
        AccountRepository accountRepository = new AccountRepository(connection);
        accountRepository.create(account1);

        accountRepository.deposit(account1.getAccountNumber(), 5000.0);

        Account account2 = new Account(2L, 1000.0);
        accountRepository.create(account2);
        accountRepository.withdraw(account2.getAccountNumber(), 999.0);

        accountRepository.transfer(account1.getAccountNumber(), account2.getAccountNumber(), 2500.0);

    }
}
