package org.example.cloud.service.impl;

import org.example.cloud.service.HrService;
import org.example.cloud.mapper.HrMapper;
import org.example.cloud.pojo.Hr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HrServiceImpl implements HrService {

    @Autowired
    private HrMapper hrMapper;

    @Override
    public List<Hr> getAll() {
        return hrMapper.getAll();
    }

    @Override
    public Hr getById(int id) {
        return hrMapper.getById(id);
    }
}
