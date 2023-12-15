package com.techpalle.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.techpalle.dao.DataAccessObject;
import com.techpalle.model.Student;

@Controller
public class StudentController {
ModelAndView  mv= new ModelAndView();
@RequestMapping("/")
public ModelAndView getStartuppage() {
	mv.setViewName("home.jsp");
	return mv;	
}
@RequestMapping(value="student" , params="reg")
public ModelAndView getRegister() {
	mv.setViewName("register.jsp");
	return mv;	
}
@RequestMapping("register student")
public ModelAndView insertStudent(HttpServletRequest request) {
	String n=request.getParameter("name");
	String e=request.getParameter("email");
	String p=request.getParameter("password");
    long num=Long.parseLong(request.getParameter("mobile"));
    Student s= new Student(n,e,p,num);
    DataAccessObject.insertStudentDao(s);
    mv.setViewName("home.jsp");
	return mv;
}
@RequestMapping(value="student" , params="show")
 public ModelAndView displayStudent() {
	 ArrayList<Student> al= DataAccessObject.getAllStudentDao();
	 mv.addObject("students",al);
	 mv.setViewName("display.jsp");
	return mv;
	 
 }
@RequestMapping(value="/deletestudent/{sno}")
public ModelAndView deleteStudent(HttpServletRequest request) {
	int sno=Integer.parseInt(request.getParameter("sno"));
	DataAccessObject.delete(sno);
	mv.setViewName("home.jsp");
	return mv;	
}
@RequestMapping("Edit")
public ModelAndView editStudent(HttpServletRequest request) {
	int sno=Integer.parseInt(request.getParameter("sno"));
	DataAccessObject.selectStudentBySno(sno);
	mv.setViewName("register.jsp");
	return mv;	
}
}
