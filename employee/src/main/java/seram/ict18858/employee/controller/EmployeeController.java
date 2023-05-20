package seram.ict18858.employee.controller;

import seram.ict18858.employee.entity.Employee;
import seram.ict18858.employee.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeServices employeeService;

    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        return employeeService.newEmployee(employee);
    }

    @GetMapping
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Employee> findById(@PathVariable Long id) {
        return Optional.ofNullable(employeeService.findById(id));
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        return employeeService.updateEmployee(id, updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable Long id) {
        employeeService.deleteById(id);
    }
}
