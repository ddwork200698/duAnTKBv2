package com.doubleD.tkb.services.impl;

import com.doubleD.tkb.models.Objectm;
import com.doubleD.tkb.repos.ObjectRepo;
import com.doubleD.tkb.services.ObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ObjectServiceImpl implements ObjectService {
    @Autowired
    ObjectRepo objectRepo;
    @Override
    public List<Objectm> getAllObject() {
        return objectRepo.findAll();
    }
}
