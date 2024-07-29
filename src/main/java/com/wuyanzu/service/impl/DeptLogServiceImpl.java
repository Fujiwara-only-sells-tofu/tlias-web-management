package com.wuyanzu.service.impl;

import com.wuyanzu.mapper.DeptLogMapper;
import com.wuyanzu.pojo.DeptLog;
import com.wuyanzu.service.DeptLogService;
import com.wuyanzu.mapper.DeptLogMapper;
import com.wuyanzu.pojo.DeptLog;
import com.wuyanzu.service.DeptLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeptLogServiceImpl implements DeptLogService {

    @Autowired
    private DeptLogMapper deptLogMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void insert(DeptLog deptLog) {
        deptLogMapper.insert(deptLog);
    }
}
