package com;

import dto.BankCard;
import dto.Subscription;
import dto.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class DbRepository {
    private static DbRepository instance;

    private DbRepository() {
    }

    public static synchronized DbRepository getInstance() {
        if (instance == null) {
            return new DbRepository();
        }

        return instance;
    }

    public void subscribe(BankCard bankCard) {
        //subscription process

        return;
    }

    public Optional<Subscription> getSubscriptionByBankCardNumber(String bankCardNumber) {
        var subscription = new Subscription(bankCardNumber, LocalDate.now().minusDays(10));
        return Optional.of(subscription);
    }

    public List<User> getAllUsers() {
        var list = new ArrayList<User>();
        list.add(new User("Petro", "Petrov", LocalDate.of(2005, 12, 1)));
        list.add(new User("Ivan", "Surname2", LocalDate.of(2000, 10, 10)));
        list.add(new User("Stepan", "Stepanov", LocalDate.of(1990, 3, 1)));
        list.add(new User("Valeria", "Surname1", LocalDate.of(2010, 12, 1)));
        list.add(new User("Petro", "Surname3", LocalDate.of(1950, 12, 1)));

        return list;
    }

    public List<Subscription> getAllSubscriptions() {
        var list = new ArrayList<Subscription>();
        list.add(new Subscription("Card1", LocalDate.of(2005, 12, 1)));
        list.add(new Subscription("Card2", LocalDate.of(2000, 10, 10)));
        list.add(new Subscription("Card3", LocalDate.of(1990, 3, 1)));
        list.add(new Subscription("Card4", LocalDate.of(2010, 12, 1)));
        list.add(new Subscription("Card1", LocalDate.of(1950, 12, 1)));

        return list;
    }
}
