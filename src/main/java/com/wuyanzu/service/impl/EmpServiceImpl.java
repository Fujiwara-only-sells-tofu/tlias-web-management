package com.wuyanzu.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wuyanzu.mapper.EmpMapper;
import com.wuyanzu.pojo.Emp;
import com.wuyanzu.pojo.PageBean;
import com.wuyanzu.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    /*
     * 分页查询
     * */
/*    @Override
    public PageBean page(Integer page, Integer pageSize) {
        //获取总记录数
        Long count = empMapper.count();
        //获取分页查询结果列表
        Integer start=(page-1)*pageSize;
        List<Emp> emps = empMapper.page(start, pageSize);
        //封装PageBean对象
        PageBean pageBean=new PageBean(count,emps);
        return pageBean;
    }*/
    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        //设置分页参数
        PageHelper.startPage(page, pageSize);
        //执行查询
        List<Emp> empList = empMapper.list(name,gender,begin,end);
        //转换为Page对象
        Page<Emp> p= (Page<Emp>) empList;
        //封装PageBean对象
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    /*
    * 删除员工
    * */
    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }
    /*
    * 添加员工
    * */
    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }
    /*
    * 根据id查询员工
    * */
    @Override
    public Emp getById(Integer id) {
        Emp emp= empMapper.getById(id);
        return emp;
    }
    /*
    * 更新数据
    * */
    @Override
    public void update(Emp emp) {
        //添加修改时间
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }
    /*
    * 登录校验
    * */
    @Override
    public Emp login(Emp emp) {
        return empMapper.getByUsernameAndPassword(emp);
    }
}
