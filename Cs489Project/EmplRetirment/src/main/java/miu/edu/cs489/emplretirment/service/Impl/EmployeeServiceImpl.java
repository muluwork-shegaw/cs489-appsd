package miu.edu.cs489.emplretirment.service.Impl;

import miu.edu.cs489.emplretirment.domain.Employee;
import miu.edu.cs489.emplretirment.repository.EmployeeRepo;
import miu.edu.cs489.emplretirment.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepo employeeRepo;
    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }


    @Override
    public Employee getEmployeeById(Long id) {
         return employeeRepo.findById(id).orElse(null);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepo.save(employee);

    }

    @Override
    public Employee updateEmployee(Long Id,Employee employee) {
        Employee existingEmployee = employeeRepo.findById(Id).orElse(null);
        if (existingEmployee != null) {
            existingEmployee.setFirstName(employee.getFirstName());
            existingEmployee.setLastname(existingEmployee.getLastname());
            existingEmployee.setYearlySalary(employee.getYearlySalary());
            return employeeRepo.save(existingEmployee);

        }
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {
       employeeRepo.deleteById(id);
    }
}
