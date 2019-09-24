package com.ls.service.impl;


import com.ls.dao.DepartmentDao;
import com.ls.pojo.Department;
import com.ls.pojo.PageBean;
import com.ls.service.DepartmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Transactional
@Service("departementService")
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentDao departmentDao;

    /*根据id查询*/
    public Department getDepartmentById (Integer deptId){
            return this.departmentDao.selectByDepartmentId(deptId);
    }

    /*查询总数*/
    public int selectCount(){
        return departmentDao.selectCount();
    }

    /*查询所有*/
    @Override
    public List<Department> selectDepartmentList() {
        return departmentDao.selectDepartmentList();
    }

    /*实现分页查询*/
    @Override
    public PageBean<Department> findByPage(int currentPage) {
        HashMap<String,Object> map = new HashMap<String,Object>();
        PageBean<Department> pageBean = new PageBean<Department>();

        //封装当前页数
        pageBean.setCurrPage(currentPage);

        //每页显示的数据
        int pageSize=5;
        pageBean.setPageSize(pageSize);

        //封装总记录数
        int totalCount = departmentDao.selectCount();
        pageBean.setTotalCount(totalCount);

        //封装总页数
        double tc = totalCount;
        Double num =Math.ceil(tc/pageSize);//向上取整
        int totalPage = num.intValue();
        pageBean.setTotalPage(totalPage);

        map.put("start",(currentPage-1)*pageSize);
        map.put("size", pageBean.getPageSize());

        //封装每页显示的数据
        List<Department> lists = departmentDao.findByPage(map);
        pageBean.setLists(lists);

        return pageBean;
    }

    /*删除一条数据*/
    public int deleteDeptById(Integer deptId){
        return departmentDao.deleteDeptById(deptId);
    }

    /*插入一条数据*/
    @Override
    public int insert(Department department){
        return  this.departmentDao.insert(department);
    }
}
