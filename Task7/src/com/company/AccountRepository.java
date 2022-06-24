package com.company;

import java.sql.*;
import java.util.Optional;

public class AccountRepository {

    private static final String INSERT = "insert into accounts (accountNumber, balance) values " + "(?, ?)";
    private static final String FIND_BY_ACCOUNT = "select * from accounts where accountNumber = (?)";

    private Connection connection;

    public AccountRepository(Connection connection) {
        this.connection = connection;
    }

    public void create(Account account) {
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, account.getAccountNumber());
            statement.setDouble(2, account.getBalance());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public Optional<Account> find(Long accountNumber) {
        try {
            PreparedStatement statement = connection.prepareStatement(FIND_BY_ACCOUNT, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, accountNumber);
            ResultSet r_set = statement.executeQuery();
            r_set.next();
            Account account = new Account(r_set.getLong(1), r_set.getDouble(2));
            statement.close();
            return Optional.ofNullable(account);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void deposit(Long accountNumber, Double amount) throws SQLException {
        Optional<Account> account = find(accountNumber);
        if (account.isPresent()) {
            Account new_account = (Account) account.get();
            String sql = "update accounts set balance = ? where accountNumber = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, new_account.getBalance() + amount);
            preparedStatement.setLong(2, new_account.getAccountNumber());
            preparedStatement.executeUpdate();
        } else {
            System.err.println("Аккаунт не найден");
        }
    }

    public void withdraw(Long accountNumber, Double amount) throws SQLException {
        Optional<Account> account = find(accountNumber);
        if (account.isPresent()){
            Account new_account = (Account) account.get();
            if (new_account.getBalance() < amount){
                System.out.println("Недостаточно средств на счете");
            } else {
                String sql = "update accounts set balance = ? where accountNumber = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setDouble(1, new_account.getBalance() - amount);
                preparedStatement.setLong(2, new_account.getAccountNumber());
                preparedStatement.executeUpdate();
            }
        } else {
            System.err.println("Аккаунт не найден");
        }
    }

    public void transfer(Long fromAccountNumber, Long toAccountNumber, Double amount) throws SQLException {
        Optional<Account> fromAccount = find(fromAccountNumber);
        Optional<Account> toAccount = find(toAccountNumber);
        if (fromAccount.isPresent() & toAccount.isPresent()){
            Account new_fromAccount = fromAccount.get();
            Account new_toAccount = toAccount.get();
            if (amount > new_fromAccount.getBalance()){
                System.out.println("Недостаточно средств на счете");
            } else {
                String firstSql = "update accounts set balance = ? where accountNumber = ?";
                String secondSql = "update accounts set balance = ? where accountNumber = ?";
                // пыталась сделать транзакцию
                try {
                    connection.setAutoCommit(false);
                    PreparedStatement firstPreparedStatement = connection.prepareStatement(firstSql);
                    firstPreparedStatement.setDouble(1, new_fromAccount.getBalance() - amount);
                    firstPreparedStatement.setLong(2, new_fromAccount.getAccountNumber());
                    firstPreparedStatement.executeUpdate();
                    PreparedStatement secondPreparedStatement = connection.prepareStatement(secondSql);
                    firstPreparedStatement.setDouble(1, new_toAccount.getBalance() + amount);
                    firstPreparedStatement.setLong(2, new_toAccount.getAccountNumber());
                    firstPreparedStatement.executeUpdate();
                    connection.commit();
                } catch (Exception e) {
                    connection.rollback();
                }
            }
        } else {
            System.err.println("Аккаунт не найден");
        }

    }
}
