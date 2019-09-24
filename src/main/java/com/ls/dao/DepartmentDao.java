package com.ls.dao;

import com.ls.pojo.Department;

import java.util.HashMap;
import java.util.List;

public interface DepartmentDao {
    /*插入一条数据*/
    int insert(Department department);

    /*根据ID查询*/
    Department selectByDepartmentId(Integer deptId);

    /*查询所有*/
    List<Department> selectDepartmentList();

    /*分页操作，调用findByPage limit分页方法*/
    List<Department> findByPage(HashMap<String,Object> map);

    /*查询用户记录总数*/
    int selectCount();

    /*删除部门信息*/
    int deleteDeptById(Integer deptId);

}
