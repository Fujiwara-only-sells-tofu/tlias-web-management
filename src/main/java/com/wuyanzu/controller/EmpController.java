package com.wuyanzu.controller;

import com.wuyanzu.anno.Log;
import com.wuyanzu.pojo.Emp;
import com.wuyanzu.pojo.PageBean;
import com.wuyanzu.pojo.Result;
import com.wuyanzu.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

//部门管理
@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;

    /*
    *分页查询数据
    * */
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate end
                       ){
      log.info("分页查询，参数：{},{}",page,pageSize);
      //调用service分页查询
        PageBean pageBean= empService.page(page,pageSize,name,gender,begin,end);
        return Result.success(pageBean);

    }
    /*
    * 删除员工
    * */
    @Log
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("删除员工，ids:{}",ids);
        //调用service删除员工
        empService.delete(ids);
        return Result.success();
    }

    /*
    * 新增员工
    * */
    @Log
    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("添加员工:{}",emp);
        //调用service层添加员工
        empService.save(emp);
        return Result.success();
    }
    /*
    * 根据id查询员工
    * */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("查询员工的id为：{}",id);
        //调用service查询员工
        Emp emp= empService.getById(id);
        return Result.success(emp);
    }

    /*
    * 更新数据
    * */
    @Log
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("更新员工信息：{}",emp);
        //调用service更新数据
        empService.update(emp);
        return Result.success();
    }
}
