package com;

import dto.BankCard;
import dto.Subscription;
import dto.User;
import services.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ServiceImpl implements Service {

    private DbRepository dbRepository;

    public ServiceImpl() {
        this.dbRepository = DbRepository.getInstance();
    }

    @Override
    public void subscribe(BankCard bankCard) {
        dbRepository.subscribe(bankCard);
    }

    @Override
    public Subscription getSubscriptionByBankCardNumber(String bankCardNumber) {
        return dbRepository.getSubscriptionByBankCardNumber(bankCardNumber)
                .orElseThrow(NoSuchSubscriptionExceprtion::new);
    }

    @Override
    public List<User> getAllUsers() {
        return dbRepository.getAllUsers();
    }

    @Override
    public double getAverageUsersAge() {
        return getAllUsers().stream()
                .mapToDouble(user -> getUserAge(user.getBirthday()))
                .average()
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public boolean isPayableUser(User user) {
        return getUserAge(user.getBirthday()) > 18;
    }

    @Override
    public List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> predicate){
        return dbRepository.getAllSubscriptions().stream()
                .filter(predicate)
                .collect(Collectors.toUnmodifiableList());
    }

    private double getUserAge(LocalDate birthday) {
        return LocalDate.now().getYear() - birthday.getYear();
    }

}
