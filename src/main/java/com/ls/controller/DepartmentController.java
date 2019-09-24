package com.ls.controller;

import com.ls.pojo.Department;
import com.ls.pojo.PageBean;
import com.ls.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/dept")
public class DepartmentController {

    @Resource
    private DepartmentService departmentService;

    @RequestMapping(value = "/getDeptList")
    public ModelAndView getDeptList(@RequestParam(value = "currentPage", defaultValue = "1",required=false) Integer currentPage){
        ModelAndView mv = new ModelAndView("index/departmentPage");
        PageBean<Department> pageBean = departmentService.findByPage(currentPage);
        List<Department> departmentList = departmentService.selectDepartmentList();

        mv.addObject("pageBean",pageBean);
        mv.addObject("departmentList",departmentList);
        mv.addObject("currentPage",currentPage);
        return mv;
    }

    /*删除操作*/
    @RequestMapping(value = "/delDept")
    @ResponseBody
    public Object delDept(@RequestParam Map input ){
        int deptId = Integer.valueOf(String.valueOf(input.get("dept")));
        Map<String,String> map = new HashMap<String,String>();
        int rev = 0;
        String errInfo = "success";
        if (deptId>0) {
            rev = departmentService.deleteDeptById(deptId);
        }
        if(rev != 1){
            errInfo = "false";
            map.put("del_dept_error","删除异常");
        }
        map.put("result",errInfo);
        return  map;
    }
}
