package com.cosmos.controller;

import com.cosmos.mapper.StaffMapper;
import com.cosmos.pojo.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StaffController {
    @Autowired
    private StaffMapper staffMapper;
    //查询所有职工列表
    @RequestMapping("/staffs")
    public String queryStaffList(Model model){
        List<Staff> staffList = staffMapper.queryStaffList();
        model.addAttribute("staffList",staffList);
        return "staff/staff";
    }
//    @RequestMapping("/staffs")
//    public String staff(Model model){
//
//        //Collection<Staff> staffs = staffDao.getAll();
//        //model.addAttribute("staffs",staffs);//放在请求域中
//        return "staf/staff";//thymeleaf默认会拼串  classpath:/templates/xxx.html
//    }
}
