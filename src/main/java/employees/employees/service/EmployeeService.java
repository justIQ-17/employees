package employees.employees.service;


import employees.employees.entity.Department;
import employees.employees.entity.Employee;
import employees.employees.entity.Position;
import employees.employees.repository.DepartmentRepository;
import employees.employees.repository.EmployeeRepository;

import employees.employees.repository.PositionRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final PositionRepository positionRepository;

    @ModelAttribute
    public void addEmployeesToModel(Model model){
        List<Employee> employees = employeeRepository.findAll();
        List<Department> departments = departmentRepository.findAll();
        List<Position> positions = positionRepository.findAll();
//        List<Employee> departmentEmployees = employeeRepository.findAllByDepartmentName();
        model.addAttribute("employees", employees);
        model.addAttribute("employee", new Employee());
        model.addAttribute("departments",departments);
        model.addAttribute("positions",positions);

    }

    public void findEmployeeById(Long employeeId,
                                 Model model){
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        model.addAttribute("employee", employee.orElse(new Employee()));

    }

    public void addEmployee(@ModelAttribute Employee employee,
                            SessionStatus sessionStatus){

        Optional<Employee> employeeOptional = employeeRepository.findEmployeeByEmail(employee.getEmail());

        if (employeeOptional.isPresent()){
            throw new IllegalStateException("email is already taken");
        }
        employee.addEmployee(employee);
        sessionStatus.setComplete();
        log.info("Adding employee: {}", employee);
        employeeRepository.save(employee);

    }

    public  void updateEmployee(@ModelAttribute Employee employee,
                                SessionStatus sessionStatus){
        log.info("Updating employee {}", employee);
        employeeRepository.save(employee);
        sessionStatus.setComplete();
    }

    public  void showUpdate(Long employeeId,
                            Model model){
        Optional<Employee> employee = employeeRepository.findById(employeeId);

        model.addAttribute("employee", employee);
    }

    public void showDepartmentEmployees(@ModelAttribute String departmentName,
                                        Model model){
        List<Employee> departmentEmployees = employeeRepository.findAllByDepartmentName(departmentName);
        model.addAttribute("departmentEmployees",departmentEmployees);
    }

    public void showPositionEmployees(@ModelAttribute String positionName,
                                        Model model){
        List<Employee> positionEmployees = employeeRepository.findAllByPositionName(positionName);
        model.addAttribute("positionEmployees",positionEmployees);
    }

    public void showDepartmentEmployeesAndPositionEmployees(@ModelAttribute String departmentName,
                                        @ModelAttribute String positionName,
                                        Model model){
        List<Employee> departmentAndPositionEmployees = employeeRepository.findAllByDepartmentNameAndPositionName(departmentName,positionName);
        model.addAttribute("departmentAndPositionEmployees",departmentAndPositionEmployees);
    }





}
