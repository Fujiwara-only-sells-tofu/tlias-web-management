package com.wuyanzu.service.impl;

import com.wuyanzu.mapper.DeptMapper;
import com.wuyanzu.mapper.EmpMapper;
import com.wuyanzu.pojo.Dept;
import com.wuyanzu.pojo.DeptLog;
import com.wuyanzu.service.DeptLogService;
import com.wuyanzu.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptLogService deptLogService;
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;
    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

//    @Transactional(rollbackFor = Exception.class)//交给了spring事务管理
    @Transactional
    @Override
    public void delete(Integer id) {
        try {
            deptMapper.deleteById(id); //根据ID删除部门数据

//            int i = 1/0;
            //if(true){throw new Exception("出错啦...");}

            empMapper.deleteByDeptId(id); //根据部门ID删除该部门下的员工
        } finally {
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("执行了解散部门的操作,此次解散的是"+id+"号部门");
            deptLogService.insert(deptLog);
        }

    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    @Override
    public Dept get(Integer id) {
        return deptMapper.get(id);
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }
}
