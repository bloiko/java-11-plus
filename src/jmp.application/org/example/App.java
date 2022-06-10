package org.example;

import com.ServiceImpl;
import com.bank.BankImpl;
import dto.BankCard;
import dto.BankCardType;
import dto.Subscription;
import dto.User;

import java.util.ServiceLoader;


import java.util.function.Predicate;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        var bank = new BankImpl();
        bank.createBankCard(new User(), BankCardType.CREDIT);

        ServiceLoader<ServiceImpl> services = ServiceLoader.load(ServiceImpl.class);

        for (ServiceImpl service : services) {
            System.out.println(service.hashCode());
        }
        var service = new ServiceImpl();
        service.getAllUsers().forEach(System.out::println);
        var subscription = service.getSubscriptionByBankCardNumber("bankCardNumber");
        System.out.println(subscription);
        service.subscribe(new BankCard());

        System.out.println("\nCards with cardName = Card1");
        service.getAllSubscriptionsByCondition(new Predicate<Subscription>() {
                    @Override
                    public boolean test(Subscription subscription) {
                        return subscription.getBankcard().equals("Card1");
                    }
                }).stream()
                .forEach(System.out::println);

        System.out.println(service.getAverageUsersAge());
    }
}
