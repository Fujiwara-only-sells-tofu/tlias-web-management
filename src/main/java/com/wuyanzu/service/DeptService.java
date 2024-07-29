package com.wuyanzu.service;

import com.wuyanzu.pojo.Dept;

import java.util.List;

//部门管理
public interface DeptService {
    List<Dept> list();

    void delete(Integer id);

    void add(Dept dept);

    Dept get(Integer id);

    void update(Dept dept);
}
