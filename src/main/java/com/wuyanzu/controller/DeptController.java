package com.wuyanzu.controller;

import com.wuyanzu.anno.Log;
import com.wuyanzu.pojo.Dept;
import com.wuyanzu.pojo.Result;
import com.wuyanzu.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*员工管理*/
@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptService deptService;
    //@RequestMapping(value = "/depts",method = RequestMethod.GET)//指定请求方式为get
    /*
    * 查询全部部门
    * */
    @GetMapping//这是一种简单方法，推荐
    public Result list(){
        log.info("查询全部部门信息");

        //调用service查询部门数据
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    /*
    * 根据部门ID删除部门
    * */
    @Log
    @DeleteMapping("{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据部门id删除部门：{}",id);
        //调用service删除部门
        deptService.delete(id);
        return Result.success();
    }

    /*
    * 新增部门
    * */
    @Log
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("新增部门：{}",dept);
        //调用service新增部门
        deptService.add(dept);
        return Result.success();
    }

    /*
    * 根据id查询部门
    * */
    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        log.info("根据id查询部门：{}",id);
        //调用service查询部门
        Dept dept=deptService.get(id);
        return  Result.success(dept);
    }

    /*
    * 根据id修改部门
    * */
    @Log
    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("根据id修改部门:{}",dept);
        //调用service修改部门
        deptService.update(dept);
        return Result.success();
    }
}


