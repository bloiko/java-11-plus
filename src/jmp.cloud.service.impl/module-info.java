import services.Service;

module jmp.cloud.service.impl{
    provides Service with com.ServiceImpl;
    requires transitive jmp.service.api;
    requires jmp.dto;
    exports com;
}