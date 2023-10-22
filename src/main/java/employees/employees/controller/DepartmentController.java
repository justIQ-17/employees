package employees.employees.controller;

import employees.employees.service.DepartmentService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequiredArgsConstructor
@Data
public class DepartmentController {
    private final DepartmentService departmentService;

//    @ModelAttribute
//    public void addDepartmentsToModel(Model model){
//        departmentService.addDepartmentsToModel(model);
//    }
}
