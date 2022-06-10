module jmp.application{
//    requires jmp.bank.api;
//    requires jmp.service.api;
    requires jmp.cloud.bank.impl;
    requires jmp.cloud.service.impl;
    requires jmp.dto;
    uses com.ServiceImpl;
}