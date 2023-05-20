package seram.ict18858.department.services;

import seram.ict18858.department.entity.Department;
import seram.ict18858.department.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DepartmentServices {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department newDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }


    public Department findById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Department not found with id " + id));
    }

    public Department updateDepartment(Long id, Department updatedDepartment) {
        return departmentRepository.findById(id)
                .map(department -> {
                    department.setName(updatedDepartment.getName());
                    department.setLocation(updatedDepartment.getLocation());
                    return departmentRepository.save(department);
                })
                .orElseThrow(() -> new RuntimeException("Department with ID " + id + " not found"));
    }

    public void deleteById(Long id) {
        departmentRepository.deleteById(id);
    }
}
