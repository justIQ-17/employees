package employees.employees.service;

import employees.employees.entity.Department;
import employees.employees.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
//    @ModelAttribute
//    public void addDepartmentsToModel(Model model) {
//        List<Department> departments = departmentRepository.findAll();
//        model.addAttribute("departments",departments);
//    }
}
