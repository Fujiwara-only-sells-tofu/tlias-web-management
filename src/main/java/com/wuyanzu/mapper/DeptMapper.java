package com.wuyanzu.mapper;

import com.wuyanzu.pojo.Dept;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//部门管理
@Mapper
public interface DeptMapper {
    /*
    * 查询全部部门信息
    * */
    @Select("select * from dept")
    List<Dept> list();
    /*
    * 根据id删除部门
    *
    * */
    @Delete("delete from dept where id=#{id}")
    void deleteById(Integer id);
    /*
    * 新增部门
    * */
    @Insert("insert into dept(name, create_time, update_time) values (#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);
    /*
    * 查询部门
    * */
    @Select("select * from dept where id=#{id}")
    Dept get(Integer id);

    /*
    * 修改部门
    * */
    @Update("update dept set name=#{name},update_time=#{updateTime} where id=#{id}")
    void update(Dept dept);
}
