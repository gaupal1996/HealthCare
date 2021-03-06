package in.nareshit.raghu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.nareshit.raghu.entity.Employee;
import in.nareshit.raghu.service.IEmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private IEmployeeService service;

	/***
	 * If End user enters /register in address bar this method is called and loads
	 * EmployeeRegister.html page from /template folder
	 */

	@GetMapping("/register")
	public String showRegister() {
		return "EmployeeRegister";
	}

	/**
	 * On Form Submit (/save+POST), Read data as Object using @ModelAttribute Call
	 * service layer with object, read ID back Create message as String use Model
	 * memory, send message to UI Return back to EmployeeRegister.html
	 */
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute Employee employee, Model model) {
		// System.out.println(model.getClass().getName());
		Integer id = service.saveEmployee(employee);
		String message = "Employee '" + id + "' Created";
		model.addAttribute("message", message);
		return "EmployeeRegister";
	}

	/****
	 * Fetch data from DB using service send data to UI using Model Return to
	 * EmployeeData.html
	 */
	@GetMapping("/all")
	public String viewAllEmployees(Model model) {
		List<Employee> list = service.getAllEmployees();
		model.addAttribute("list", list);
		return "EmployeeData";
	}

	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam Integer id, Model model) {
		// call service
		service.deleteEmployee(id);
		// one success message
		String message = "Employee '" + id + "' Deleted";
		model.addAttribute("message", message);

		// get latest data
		List<Employee> list = service.getAllEmployees();
		model.addAttribute("list", list);
		return "EmployeeData";
	}

	@GetMapping("/edit")
	public String showEmployeeEdit(@RequestParam Integer id, Model model) {
		// load object from DB
		Employee employee = service.getOneEmployee(id);
		// send object to UI
		model.addAttribute("employee", employee);
		// return to View page
		return "EmployeeEdit";
	}

	@PostMapping("/update")
	public String updateEmployee(@ModelAttribute Employee employee) {
		service.updateEmployee(employee);
		return "redirect:all";
	}
}
