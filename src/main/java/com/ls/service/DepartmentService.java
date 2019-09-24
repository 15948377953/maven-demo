package com.ls.service;

import com.ls.pojo.Department;
import com.ls.pojo.PageBean;
import java.util.List;

public interface DepartmentService {
    Department getDepartmentById (Integer deptId);

    int insert(Department department);

    PageBean<Department> findByPage(int currentPage);

    List<Department> selectDepartmentList();

    int selectCount();

    int deleteDeptById(Integer deptId);
}
