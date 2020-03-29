package com.cognizant.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.model.Student;
import com.cognizant.service.ServiceImpl;

@Controller
public class StudentController {

	@Autowired
	private ServiceImpl studentservice;

	public ServiceImpl getStudentservice() {
		return studentservice;
	}

	public void setStudentservice(ServiceImpl studentservice) {
		this.studentservice = studentservice;
	}

	@RequestMapping("index")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("index");

		return mv;
	}

	@RequestMapping("insert")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		Student student = new Student(id, name);

		int insert = studentservice.insert(student);
		System.out.println("Total record inserted: " + insert);

		if (insert > 0) {
			System.out.println("Status: success");
			mv.addObject("result", "SUCCESS");
		} else {
			System.out.println("Stause: Failure");
			mv.addObject("result", "FAILURE");
		}

		mv.setViewName("insert");

		return mv;
	}

	@RequestMapping("update")
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		Student student = new Student(id, name);

		int update = studentservice.update(student);
		System.out.println("Total record updated: " + update);

		if (update > 0) {
			System.out.println("Status: success");
			mv.addObject("result", "SUCCESS");
		} else {
			System.out.println("Stause: Failure");
			mv.addObject("result", "FAILURE");
		}

		mv.setViewName("update");

		return mv;
	}

	@RequestMapping("delete")
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();

		int id = Integer.parseInt(request.getParameter("id"));

		int delete = studentservice.delete(id);
		System.out.println("Total record deleted: " + delete);

		if (delete > 0) {
			System.out.println("Status: success");
			mv.addObject("result", "SUCCESS");
		} else {
			System.out.println("Stause: Failure");
			mv.addObject("result", "FAILURE");
		}

		mv.setViewName("delete");

		return mv;
	}
	
	@RequestMapping("display")
	public ModelAndView display(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		
		List<Student> students=studentservice.getall();
		mv.addObject("list", students);
		if(students.isEmpty())
		{
			System.out.println("Status: Failure");
			mv.addObject("result", "FAILURE");
		}
		else
		{
			System.out.println("Status: Success");
			mv.addObject("result", "SUCCESS");
		}
		
		

		mv.setViewName("display");

		return mv;
	}
	

}
