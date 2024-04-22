package com.ceetech.mycoolapp.controller;

import com.ceetech.mycoolapp.entity.Employee;
import com.ceetech.mycoolapp.service.EmployeeService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "employees/employees";
    }

    @GetMapping("/add")
    public String addEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "employees/add";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {

        employeeService.saveUpdate(employee);

        return "redirect:/employees/list";
    }

    @GetMapping("/update")
    public String updateEmployee(@RequestParam("employeeId") int employeeId,  Model model) {

        Employee employee = employeeService.findById(employeeId);

        model.addAttribute("employee", employee);

        return "employees/add";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int employeeId,  Model model) {

        employeeService.deleteById(employeeId);

        return "redirect:/employees/list";
    }


}
