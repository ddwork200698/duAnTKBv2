package com.doubleD.tkb.services;

import com.doubleD.tkb.models.Objectm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ObjectService {
    List<Objectm> getAllObject();
}
