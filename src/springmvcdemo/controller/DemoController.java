package springmvcdemo.controller;

import java.util.ArrayList;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import springmvcdemo.model.Student;

@Controller
public class DemoController {
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		Student student = new Student();
		student.setName("Anh Tran");
		
		List<String> books = new ArrayList<String>();
		books.add("book1");
		books.add("book2");
		student.setBooks(books);
		
		ModelAndView mav = new ModelAndView("index.jsp","model",student);
		return mav;
	}
	
	@RequestMapping(value="/submitStudentInfo",method=RequestMethod.POST)
	public ModelAndView submitStudentInfo(ModelMap model, @ModelAttribute("model") Student student){
		
		List<String> listBooks = student.getBooks();
		boolean bookSamename = checkSameBookName(listBooks);
		
		String message = "Update success !!!";
		if (bookSamename) {
			message = "Books must have different name !!!";
		}
		model.addAttribute("message", message);
		
		ModelAndView mav = new ModelAndView("index.jsp","model",student);
		return mav;
	}
	
	 private boolean checkSameBookName(List<String> listBooks) {  
         for(int i =0; i<listBooks.size(); i++){  
              String firstBookName = listBooks.get(i);  
              for(int j = i+1; j<listBooks.size(); j++){  
                   String secondBookName = listBooks.get(j);  
                   if(firstBookName.equalsIgnoreCase(secondBookName)){  
                        return true;  
                   }  
              }  
         }  
         return false;  
    }
	 
	 @RequestMapping(value="/getStudentInfo", params={"studentId"})  
     public @ResponseBody Student getStudentInfo(  
               @RequestParam(value ="studentId") String studentId){  
          if(studentId!= null){ 
               Student s = new Student();  
               s.setId(studentId);  
               s.setName("Coder Tuan Anh");  
               s.setAddress("Coder Tuan Anh");  
               return s;  
          }  
          return null;  
     }  
	
}
