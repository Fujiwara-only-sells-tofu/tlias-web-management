package com.wuyanzu.service;

import com.wuyanzu.pojo.Emp;
import com.wuyanzu.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

//员工管理
public interface EmpService {
    /*
    * 分页查询
    * */
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    /*
    * 删除员工
    * */
    void delete(List<Integer> ids);
    /*
    * 添加员工
    * */
    void save(Emp emp);
    /*
    * 根据id查询员工
    * */
    Emp getById(Integer id);
    /*
    * 更新数据
    * */
    void update(Emp emp);
    /*
    * 登录操作
    * */
    Emp login(Emp emp);
}
