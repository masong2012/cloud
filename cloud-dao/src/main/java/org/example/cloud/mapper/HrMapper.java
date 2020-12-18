package org.example.cloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.cloud.pojo.Hr;

import java.util.List;

@Mapper
public interface HrMapper {
    public List<Hr> getAll();
    public Hr getById(@Param("id")int id);
}
