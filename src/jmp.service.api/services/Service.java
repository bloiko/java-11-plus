package services;

import dto.BankCard;
import dto.Subscription;
import dto.User;

import java.util.List;
import java.util.function.Predicate;

public interface Service {
    void subscribe(BankCard bankCard);

    Subscription getSubscriptionByBankCardNumber(String bankCardNumber);

    List<User> getAllUsers();

    double getAverageUsersAge();

    boolean isPayableUser(User user);

    List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> predicate);
}
