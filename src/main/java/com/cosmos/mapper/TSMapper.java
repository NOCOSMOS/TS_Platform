package com.cosmos.mapper;

import com.cosmos.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface TSMapper {
    List<Staff> queryStaffList();//列出教师表
    Staff queryStaffById(String id);//查询教师(根据id)
    String queryTeaNameById(String id);//搜名字(根据id)
    void addStaff(Staff staff);//增加教师
    void deleteStaff(String id);//删除教师(根据id)
    void AdminUpdateStaff(Staff staff);//管理员修改教师信息
    void TeaUpdateStaff(Staff staff);//教师修改教师信息
    //分界线---------------------------------------------------------------------------
    List<Student> queryStudentList();//列出学生表
    Student queryStudentById(String id);//搜学生(根据id)
    String queryStuNameById(String id);//搜名字(根据id)
    List<Student> queryStudentByClasses(String classes);//列出学生表(根据班级)
    String queryClassesByName(String username);//搜班级(根据名)
    void addStudent(Student student);//增加学生
    void deleteStudent(String id);//删除学生(根据id)
    void AdminUpdateStudent(Student student);//管理员修改学生信息
    void StuUpdateStudent(Student student);//学生修改学生信息
    //分界线---------------------------------------------------------------------------
    List<Course> queryCourseList();//查询所有课程
    List<Course> queryStuCourse(String id);//查询学生的课程(根据id)
    List<Course> queryTeaCourse(String id);//查询老师的课程(根据id)
    Course queryCourse(String id);//查询课程细节()
    void addCourse(Course course);//开设课程
    List<Student> queryCourseStuList(String id);//查询课程学生名单(根据课程id)
    List<String> queryCourseStuID(String id);//查询课程学生的id(根据课程id)
    //分界线---------------------------------------------------------------------------
    List<Task> queryTaskList(String id);//查询课程的所有作业
    Task queryTask(String id);//查询作业详情
    void addTask(Task task);//增加作业
    void updateTask(@Param("task")Task task,@Param("oldID")String oldID);//编辑作业(根据旧id,不改文件)
    void updateTaskF(@Param("task")Task task,@Param("oldID")String oldID);//编辑作业(根据旧id,改变文件)
    void changeTaskID(String id,String oldID);//变更作业-学生联系表里的作业id(当作业编号改变时(编辑作业))
    void addTaskStudent(String studentID, String taskID);//创建作业-学生联系表(在增添作业或者课程增加学生时进行)
    void submitTask(Date submitDate,String fileName,String studentID,String taskID);//提交作业
    Map<String,Object> queryMyTaskFile(String studentID, String taskID);//查询我的作业
    List<Map<String,Object>> queryStuTaskFileList(String taskID);//查询该作业的学生文件
    void taskCorrecting(String studentID,String taskID,Integer score);//批改作业
    //分界线---------------------------------------------------------------------------
    List<Comment> queryCommentList(String position);//查询所有评论
    void discuss(String id,String name,Date date,String text,String position,String replier);//发表评论
}
