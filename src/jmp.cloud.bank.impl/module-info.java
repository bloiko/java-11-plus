import com.api.Bank;

module jmp.cloud.bank.impl{
    provides Bank with com.bank.BankImpl;
    requires jmp.dto;
    requires transitive jmp.bank.api;
    exports com.bank;
}