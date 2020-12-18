package org.example.cloud.service;

import org.example.cloud.pojo.Hr;

import java.util.List;

public interface HrService {
    public List<Hr> getAll();
    public Hr getById(int id);
}
