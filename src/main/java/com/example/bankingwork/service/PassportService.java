package com.example.bankingwork.service;

import com.example.bankingwork.models.Passport;
import com.example.bankingwork.repository.PassportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PassportService {
    @Autowired
    private PassportRepository passportRepository;

    public Optional<Passport> getPassportById(Long id){
        Optional<Passport> byId = passportRepository.findById(id);
        return byId;
    }
}
