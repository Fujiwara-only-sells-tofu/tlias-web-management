package com.wuyanzu.mapper;

import com.wuyanzu.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

//员工管理
@Mapper
public interface EmpMapper {
/*    *//*
    * 查询总记录数
    * *//*
    @Select("select count(*) from emp")
    public Long count();

    *//*
    *
    * 分页查询，获取列表数据
    * *//*
    @Select("select * from emp limit #{start},#{pageSize}")
    public List<Emp> page(Integer start,Integer pageSize);*/

    /*
    * 员工信息查询
    * */
//    @Select("select * from emp ")
    //动态SQl写在XML文件中
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);
    /*
    * 删除员工
    * */
    void delete(List<Integer> ids);

    /*
    添加员工
    * */
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)"+
            "values(#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime});")
    void insert(Emp emp);
    /*
    * 根据id查询员工
    * */
    @Select("select * from emp where id=#{id}")
    Emp getById(Integer id);
    /*
    更新数据
    * */
    void update(Emp emp);
    /*
    * 根据用户名和密码查询用户
    * */
    @Select("select * from emp where username=#{username} and password=#{password}")
    Emp getByUsernameAndPassword(Emp emp);

    /*
    * 根据部门id删除员工
    * */
    @Delete("delete  from emp where dept_id=#{deptId}")
    void deleteByDeptId(Integer deptId);
}
