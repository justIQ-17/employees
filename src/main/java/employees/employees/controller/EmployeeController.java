package employees.employees.controller;

import employees.employees.entity.Department;
import employees.employees.entity.Employee;
import employees.employees.repository.EmployeeRepository;
import employees.employees.service.DepartmentService;
import employees.employees.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;




@Controller
@SessionAttributes("employee")
@RequiredArgsConstructor
@RequestMapping("/employees")
@Data
public class EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;

    @ModelAttribute
    public void addEmployeesToModel(Model model) {
        employeeService.addEmployeesToModel(model);
    }

    @ModelAttribute(name = "employee")
    public Employee employee() {
        return new Employee();
    }


    @GetMapping()
    public String displayEmployees() {
        return "employeeList";
    }

    @GetMapping(path = "/details/{employeeId}")
    public String findEmployeeById(@PathVariable("employeeId") Long employeeId,
                                   Model model) {
        employeeService.findEmployeeById(employeeId,model);

        return "details";
    }

    @GetMapping(path = "/delete/{employeeId}")
    public String deleteEmployee(@PathVariable("employeeId") Long employeeId) {
        employeeRepository.deleteById(employeeId);

        return "redirect:/employees";
    }

    @GetMapping("/addEmployee")
    public String showAddEmployee() {
        return "addEmployee";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@Valid @ModelAttribute Employee employee,
                              Errors errors,
                              SessionStatus sessionStatus) {
        //TODO: Should I put validation checking in controller or service?
        if (errors.hasErrors()) {
            return "addEmployee";
        }
        employeeService.addEmployee(employee,sessionStatus);

        return "redirect:/employees";
    }

    //    @PostMapping(path = "/update/{id}")
//    public String updateEmployee(@PathVariable("id")Long id,
//                                 @RequestBody Employee employee,
//                                 Model model){
//        Optional<Employee> optional = employeeRepository.findById(id);
//        employee = optional.get();
//
//        model.addAttribute("employee", employee);
//
//        log.info("Updating employee: {}", employee);
//
//        employeeRepository.save(employee);
//
//        return "redirect:/employees";
//
//    }
    @PostMapping(path = "/update")
    public String updateEmployee(@Valid @ModelAttribute Employee employee,
                                 Errors errors,
                                 SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return "update";
        }

        employeeService.updateEmployee(employee,sessionStatus);

        return "redirect:/employees";
    }

    @GetMapping(path = "/update/{employeeId}")
    public String showUpdate(@PathVariable Long employeeId,
                             Model model) {
        employeeService.showUpdate(employeeId,model);

        return "update";
    }

    @GetMapping(path = "/{departmentName}")
    public String showDepartmentEmployees(@PathVariable @ModelAttribute String departmentName,
                                          Model model){
        employeeService.showDepartmentEmployees(departmentName,model);

        return "departmentEmployeesList";
    }

    @GetMapping(path = "/all/{positionName}")
    public String showPositionEmployees(@PathVariable @ModelAttribute String positionName,
                                          Model model){
        employeeService.showPositionEmployees(positionName,model);

        return "positionEmployeesList";
    }

    @GetMapping(path = "/{departmentName}/{positionName}")
    public String showPositionEmployees(@PathVariable @ModelAttribute String departmentName,
                                        @PathVariable @ModelAttribute String positionName,
                                        Model model){
        employeeService.showDepartmentEmployeesAndPositionEmployees(departmentName,positionName,model);

        return "departmentAndPositionEmployeesList";
    }


}
