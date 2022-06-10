package com.bank;

import com.api.Bank;
import dto.BankCard;
import dto.BankCardType;
import dto.CreditBankCard;
import dto.User;

import java.util.Optional;

public class BankImpl implements Bank {

    @Override
    public BankCard createBankCard(User user, BankCardType bankCardType) {
        return new BankCard("Card", user);
    }
}
